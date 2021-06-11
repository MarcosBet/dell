package com.residencia.dell.controllers;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrderlinesServices;
import com.residencia.dell.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.chrono.ThaiBuddhistEra;
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

    //****************************************************************************************************************
    @GetMapping("/count")
    public Long count() {
        return orderLinesServices.count();
    }
   //****************************************************************************************************************

    @PostMapping
    public ResponseEntity<Orderlines>Save (@RequestBody Orderlines orderlines){
        HttpHeaders headers = new HttpHeaders();

        Orderlines novoOrderlines = orderLinesServices.save(orderlines);

        if(null!=novoOrderlines){
            return new ResponseEntity<>(novoOrderlines, headers, HttpStatus.OK);}
        else{
            return new ResponseEntity<>(novoOrderlines,headers,HttpStatus.BAD_REQUEST);
        }

    }
    //****************************************************************************************************************
    @PutMapping

    public Orderlines update(Orderlines orderlines){
        return  orderLinesServices.update(orderlines);
    }

    //****************************************************************************************************************
    @DeleteMapping

    public ResponseEntity<Orderlines>delete(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = orderLinesServices.delete(id);

        if(isRemoved){
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }




}
