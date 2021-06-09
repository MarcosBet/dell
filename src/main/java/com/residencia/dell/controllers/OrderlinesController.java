package com.residencia.dell.controllers;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrderlinesServices;
import com.residencia.dell.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/orderlines")
public class OrderlinesController {
    @Autowired
    public OrderlinesServices orderLinesServices;


    @GetMapping("/{id}/{orderId}")
    public  ResponseEntity<Orderlines>findById(@PathVariable Integer id,@PathVariable Integer orderId ){
        HttpHeaders headers= new HttpHeaders();
        return new ResponseEntity<>(orderLinesServices.findById(id,orderId),headers, HttpStatus.OK);
    }

    //****************************************************************************************************************

    @GetMapping
    public ResponseEntity<List<Orderlines>>findAll(
            @RequestParam(required = false)Integer  pages,
            @RequestParam(required = false)Integer registersQuantity)
            throws Exception{
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(orderLinesServices.findAll(pages, registersQuantity),headers,HttpStatus.OK);

    }

}
