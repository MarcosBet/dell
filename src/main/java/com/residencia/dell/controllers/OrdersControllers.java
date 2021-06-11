package com.residencia.dell.controllers;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrdersServices;
import com.residencia.dell.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersControllers {
    @Autowired
    OrdersServices ordersService;



//    @GetMapping("/{id}")
//    public ResponseEntity<Orders> findById(@PathVariable Integer id){
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<>(ordersService.findById(id),headers, HttpStatus.OK);}


    @GetMapping("/{id}")
    public ResponseEntity<OrdersVO> findById(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.findByIdVO(id),headers, HttpStatus.OK);}


    //****************************************************************************************************************

    @GetMapping
    public ResponseEntity<List<Orders>>findAll(
        @RequestParam(required = false)Integer  pagina,
        @RequestParam(required = false)Integer qtdRegistros)
        throws Exception{
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.findAll(pagina, qtdRegistros),headers,HttpStatus.OK);

    }

//    @GetMapping("/listar-todos")
//    public ResponseEntity<List<OrderVO>>findAllvo(
//            @RequestParam(required = false)Integer pagina,
//            @RequestParam(required = false)Integer qtdRegistros)
//            throws Exception{
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<>(ordersService.findAllvo(pagina, qtdRegistros)),headers,HttpStatus.Ok);
//
//
//    )


    //****************************************************************************************************************

    @PostMapping
    public ResponseEntity<Orders>Save (@RequestBody Orders orders){
        HttpHeaders headers = new HttpHeaders();

        Orders novoOrders = ordersService.save(orders);

        if(null!=novoOrders){
            return new ResponseEntity<>(novoOrders, headers, HttpStatus.OK);}
        else{
            return new ResponseEntity<>(novoOrders,headers,HttpStatus.BAD_REQUEST);
        }

    }
    //****************************************************************************************************************
    @PutMapping("/{id}")
    public ResponseEntity<Orders> update(@PathVariable Integer id, @RequestBody Orders orders) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.update(id, orders), headers, HttpStatus.OK);
    }

    //****************************************************************************************************************
    @DeleteMapping

    public ResponseEntity<Orders>delete(@RequestParam Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = ordersService.delete(id);

        if(isRemoved){
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }


}
