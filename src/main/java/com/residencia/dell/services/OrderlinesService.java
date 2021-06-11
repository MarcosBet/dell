package com.residencia.dell.services;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.vo.OrderlinesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderlinesService {

    @Autowired
    OrderlinesRepository orderlinesRepository;

    @Autowired
    OrdersRepository ordersRepository;

    public Orderlines findById(Integer orderlinesId, Integer ordersByOrderid) {
        Orders orders = ordersRepository.findById(ordersByOrderid).get();
        return orderlinesRepository.findByOrderLineIdAndOrders(orderlinesId, orders);
    }

    public List<Orderlines> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
        Pageable page = null;
        List<Orderlines> listOrderlines = null;
        List<Orderlines> listOrderlinesComPaginacao = null;

        try {
            if (null != pagina && null != qtdRegistros) {
                page = PageRequest.of(pagina, qtdRegistros);
                listOrderlinesComPaginacao = orderlinesRepository.findAll(page).getContent();

                return listOrderlinesComPaginacao;
            } else {
                listOrderlines = orderlinesRepository.findAll();

                return listOrderlines;
            }
        } catch (Exception e) {
            throw new Exception("Nâo foi possível recuperar a lista de pedidos ::" + e.getMessage());
        }
    }

    public List<OrderlinesVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
        Pageable page = null;
        List<Orderlines> listOrderlines = null;
        List<Orderlines> listOrderlinesComPaginacao = null;
        List<OrderlinesVO> listOrdersVO = new ArrayList<>();

        try {
            if (null != pagina && null != qtdRegistros) {

                page = PageRequest.of(pagina, qtdRegistros);
                listOrderlinesComPaginacao = orderlinesRepository.findAll(page).getContent();

                for (Orderlines lOrders : listOrderlinesComPaginacao) {
                    listOrdersVO.add(convertEntidadeParaVO(lOrders));
                }

            } else {
                listOrderlines = orderlinesRepository.findAll();

                for (Orderlines lOrderlines : listOrderlines) {
                    listOrdersVO.add(convertEntidadeParaVO(lOrderlines));
                }
            }
        } catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
        }
        return listOrdersVO;
    }

    public long count() {
        return orderlinesRepository.count();
    }

    public OrderlinesVO saveVO(OrderlinesVO orderlinesVO) {
        Orderlines novaOrderlines = converteVOParaEntidade(orderlinesVO);
        Orderlines orderlines = orderlinesRepository.save(novaOrderlines);

        return convertEntidadeParaVO(novaOrderlines);
    }

    public Orderlines update(Orders orderlinesId, Integer orders) {
        Orderlines orderlines = orderlinesRepository.findByOrderLineIdAndOrders(orders, orderlinesId);
        return orderlinesRepository.save(orderlines);
    }

    public boolean delete(Integer id) {
        if (id != null) {
            orderlinesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private OrderlinesVO convertEntidadeParaVO(Orderlines orderlines) {
        OrderlinesVO orderlinesVO = new OrderlinesVO();

        orderlinesVO.setOrderlineid(orderlines.getOrderLineId());
        orderlinesVO.setOrdersVO(orderlines.getOrders().getOrderId());
        orderlinesVO.setProdId(orderlines.getProdId());
        orderlinesVO.setQuantity(orderlines.getQuantity());
        orderlinesVO.setOrderDate(orderlines.getOrderDate());

        return orderlinesVO;
    }

    private Orderlines converteVOParaEntidade(OrderlinesVO orderlinesVO) {
        Orderlines orderlines = new Orderlines();


        orderlines.setOrderLineId(orderlinesVO.getOrderlineid());
        orderlines.setOrders(ordersRepository.getById(orderlinesVO.getOrdersVO()));
        orderlines.setProdId(orderlinesVO.getProdId());
        orderlines.setQuantity(orderlinesVO.getQuantity());
        orderlines.setOrderDate(orderlinesVO.getOrderDate());


        return orderlines;
    }
}
