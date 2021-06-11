package com.residencia.dell.services;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderlinesService {

    @Autowired
    OrderlinesRepository orderlinesRepository;

    @Autowired
    OrdersRepository ordersRepository;

    public Orderlines findById(Integer orderlinesId, Integer ordersByOrderid) {
        Orders orders = ordersRepository.findById(ordersByOrderid).get();
        return orderlinesRepository.findByOrderLineIdAndOrders(orderlinesId, orders);
    }

    public List<Orderlines> findAll(Integer orderlinesId, Orders ordersByOrderid) {
        return orderlinesRepository.findAll();
    }

    public long count() {
        return orderlinesRepository.count();
    }

    public Orderlines save(Orderlines orderlines, Integer orderlinesId, Integer ordersByOrderid) {
        Orders orders = ordersRepository.findById(ordersByOrderid).get();
        Orderlines newOrderlines = orderlinesRepository.save(orderlines);
        if (newOrderlines.getOrderLineId() != null) {
            return newOrderlines;
        } else {
            return null;
        }
    }

    public Orderlines update(Orderlines orderlines) {
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
}
