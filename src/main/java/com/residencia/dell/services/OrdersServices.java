package com.residencia.dell.services;



import com.residencia.dell.entities.Customers;
import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.NotaFiscalVO;
import com.residencia.dell.vo.OrderlinesVO;
import com.residencia.dell.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServices {

    @Autowired
    public OrdersRepository ordersRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    OrderlinesRepository orderlinesRepository;

//********************************************************************************************************************

    public Orders findById (Integer id){

        return ordersRepository.findById(id).get();
    }
//********************************************************************************************************************

    public OrdersVO findByIdVO (Integer id){
        Orders newOrdersVO = ordersRepository.findById(id).get();
        return convertEntidadeParaVO(newOrdersVO);
    }


//********************************************************************************************************************

    public List<Orders> findAll(Integer pagina, Integer qtdRegistros)throws Exception{
        Pageable page = null;
        List<Orders>listOrders = null;
        List<Orders>listOrdersComPaginacao=null;

        try{

            if (null!= pagina && null!= qtdRegistros){
                page = PageRequest.of(pagina, qtdRegistros);
                listOrdersComPaginacao= ordersRepository.findAll(page).getContent();
                return listOrdersComPaginacao;
            }
            else{
                listOrders=ordersRepository.findAll();

                return listOrders;
            }


        } catch (Exception e) {
            throw new Exception("Não foi possivel recuperar a lista de pedidos::"+e.getMessage());
        }

    }

//********************************************************************************************************************


    public List<OrdersVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
        Pageable page = null;
        List<Orders> listOrders = null;
        List<Orders> listOrdersComPaginacao = null;
        List<OrdersVO> listOrdersVO = new ArrayList<>();

        try {
            if (null != pagina && null != qtdRegistros) {

                page = PageRequest.of(pagina, qtdRegistros);
                listOrdersComPaginacao = ordersRepository.findAll(page).getContent();

                for (Orders lOrders : listOrdersComPaginacao) {
                    listOrdersVO.add(convertEntidadeParaVO(lOrders));
                }

            } else {
                listOrders = ordersRepository.findAll();

                for (Orders lOrders : listOrders) {
                    listOrdersVO.add(convertEntidadeParaVO(lOrders));
                }

            }
        } catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
        }

        return listOrdersVO;
    }
    //********************************************************************************************************************




    public long count() { return ordersRepository.count();}

//********************************************************************************************************************

    public Orders save (Orders orders){
        Orders newOrders = ordersRepository.save(orders);
        if(newOrders.getOrderId()!=null){
            return newOrders;
        }
        else{ return null; }

    }

//********************************************************************************************************************

//    public Orders update(Integer id, Orders orders){
//
//        return ordersRepository.save(orders);
//    }
//
//    public boolean delete(Integer id) {
//        if (id != null) {
//            ordersRepository.deleteById(id);
//            return true;
//        } else {
//            return false;
//        }
//    }


public Orders update(Integer id, Orders orders) {
		Orders newOrders = ordersRepository.findById(id).get();
		updateDados(newOrders, orders);
		return ordersRepository.save(newOrders);
	}

	private void updateDados(Orders newOrders, Orders orders) {
		newOrders.setOrderDate(orders.getOrderDate());
		newOrders.setCustomer(orders.getCustomer());
		newOrders.setNetAmount(orders.getNetAmount());
		newOrders.setTax(orders.getTax());
		newOrders.setTotalAmount(orders.getTotalAmount());
	}



    //********************************************************************************************************************

    private OrdersVO convertEntidadeParaVO(Orders orders) {
        OrdersVO ordersVO = new OrdersVO();
        List<OrderlinesVO> listOrderlinesVO = new ArrayList<>();

        ordersVO.setNetAmount(orders.getNetAmount());
        ordersVO.setOrderDate(orders.getOrderDate());
        ordersVO.setOrderId(orders.getOrderId());
        ordersVO.setTax(orders.getTax());
        ordersVO.setTotalAmount(orders.getTotalAmount());

        for (Orderlines lOrderLines : orders.getListOrderLines()) {
            OrderlinesVO orderlinesVO = new OrderlinesVO();

            orderlinesVO.setOrderDate(lOrderLines.getOrderDate());
            orderlinesVO.setOrderlineid(lOrderLines.getOrderLineId());
            orderlinesVO.setProdId(lOrderLines.getProdId());
            orderlinesVO.setQuantity(lOrderLines.getQuantity());

            listOrderlinesVO.add(orderlinesVO);
        }

        ordersVO.setListOrderLinesVO(listOrderlinesVO);

        return ordersVO;
    }




    private Orders converteVOParaEntidade (OrdersVO ordersVO) {
        Orders orders = new Orders();

        Customers customer = customersRepository.getById(ordersVO.getCustomersId());

        orders.setNetAmount(ordersVO.getNetAmount());
        orders.setOrderDate(ordersVO.getOrderDate());
        orders.setTax(ordersVO.getTax());
        orders.setTotalAmount(ordersVO.getTotalAmount());
        orders.setCustomer(customer);

        List<Orderlines> listOrderlines = new ArrayList<>();
        for (OrderlinesVO lOrderlinesVO : ordersVO.getListOrderLinesVO()) {
            Orderlines orderLines = new Orderlines();

            orderLines.setOrderDate(lOrderlinesVO.getOrderDate());
            orderLines.setOrderLineId(lOrderlinesVO.getOrderlineid());
            orderLines.setProdId(lOrderlinesVO.getProdId());
            orderLines.setQuantity(lOrderlinesVO.getQuantity());

            listOrderlines.add(orderLines);
            orders.setListOrderLines(listOrderlines);
        }
        return orders;
    }




    //********************************************************************************************************************

    public NotaFiscalVO emitirNota(Integer orderId){
        Orders orders = ordersRepository.getById(orderId);
        NotaFiscalVO notaVO = new NotaFiscalVO();
        List<OrderlinesVO> listOrderlinesVO = new ArrayList<>();
        List<Orderlines> orderlinesList = orders.getListOrderLines();

        for (Orderlines orderlines : orderlinesList){
            OrderlinesVO orderlinesVO = new OrderlinesVO();
            orderlinesVO.setOrderlineid(orderlines.getOrderLineId());
            orderlinesVO.setQuantity(orderlines.getQuantity());
            orderlinesVO.setTitle(orderlines.getTitle());
            orderlinesVO.setOrderDate(orderlines.getOrderDate());
            listOrderlinesVO.add(orderlinesVO);
        }
        if(orders.getCustomer()!=null){
            notaVO.setCustomerFirstName(orders.getCustomer().getFirstName());
            notaVO.setCustomerFirstName(orders.getCustomer().getLastName());
        }
        else {
            notaVO.setCustomerFirstName(null);
            notaVO.setCustomerLastName(null);
        }
        notaVO.setOrderId(orders.getOrderId());
        notaVO.setOrderDate(orders.getOrderDate());
        notaVO.setTotalAmount(orders.getTotalAmount());
        notaVO.setTotalAmount(orders.getTotalAmount());

        notaVO.setListOrderlineVO(listOrderlinesVO);

        return notaVO;
    }


    public OrdersVO saveVO(OrdersVO ordersVO) {
        Orders novaOrder = converteVOParaEntidade(ordersVO);
        Orders order = ordersRepository.save(novaOrder);

        List<Orderlines> listOrderline = order.getListOrderLines();
        for (int i = 0; i < listOrderline.size(); i++) {
            listOrderline.get(i).setOrderLineId(i + 100);
            orderlinesRepository.save(listOrderline.get(i));
        }
        return convertEntidadeParaVO(novaOrder);
    }

    public boolean delete(Integer id) {
        if (id != null) {
            orderlinesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
