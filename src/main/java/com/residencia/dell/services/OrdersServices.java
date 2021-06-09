package com.residencia.dell.services;


import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.OrdersRepository;
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


//********************************************************************************************************************

    public Orders findById (Integer id){
        Orders newOrders = ordersRepository.findById(id).get();
        return newOrders;
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

    public Orders update(Orders orders ){

        return ordersRepository.save(orders);
    }

    public boolean delete(Integer id) {
        if (id != null) {
            ordersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
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
//    private Orders convertVOParaEntidade( OrdersVO ordersVO){
//        Orders orders = new Orders();
//        List<Orderlines>listOrderlines = new ArrayList<>();
//
//        orders.getNetAmount(ordersVO.setNetAmount());
//    }



}
