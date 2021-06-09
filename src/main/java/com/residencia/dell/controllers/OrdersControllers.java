package com.residencia.dell.controllers;

import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrdersServices;
import com.residencia.dell.vo.OrdersVO;
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

}
