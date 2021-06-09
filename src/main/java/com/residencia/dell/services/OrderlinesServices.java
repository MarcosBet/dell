package com.residencia.dell.services;

import com.residencia.dell.entities.Orderlines;

import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderlinesServices {

    @Autowired
    public OrderlinesRepository orderlinesRepository;

//********************************************************************************************************************



    public Orderlines findById (Integer orderLineid , Integer orderId){
        Orderlines orders = orderlinesRepository.findById(orderId).get();
        return orderlinesRepository.findByOrderLineIdAndOrders(orderLineid, orders);
    }

//********************************************************************************************************************
//public List<Orderlines> findAll(Integer pagina, Integer id){
//
//    return orderlinesRepository.findAll();
//}

    public List<Orderlines> findAll(Integer page, Integer registersQuantity) throws Exception {
        PageRequest pages = null;
        List<Orderlines> listOrders = null;
        List<Orderlines> listOrdersPageable = null;

        try {
            if (null != page && null != registersQuantity){
                pages = PageRequest.of(page, registersQuantity);
                listOrdersPageable = orderlinesRepository.findAll(pages).getContent();

                return  listOrdersPageable;
            }
            else {
                listOrders = orderlinesRepository.findAll();

                return listOrders;
            }
        }
        catch (Exception e) {
            throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
        }
    }

//********************************************************************************************************************

    public long count() { return orderlinesRepository.count();}

//********************************************************************************************************************

    public Orderlines save (Orderlines orderlines){
        Orderlines newOrderline = orderlinesRepository.save(orderlines);

            return newOrderline;}


//********************************************************************************************************************

    public Orderlines update(Orderlines orderlines ){

        return orderlinesRepository.save(orderlines);
    }
//********************************************************************************************************************

    public boolean delete(Integer id) {
        if (id != null) {
            orderlinesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    public Orderlines findById (Integer id){
        Orderlines newOrderLines = orderlinesRepository.findById(id).get();
        return newOrderLines;
    }
}
