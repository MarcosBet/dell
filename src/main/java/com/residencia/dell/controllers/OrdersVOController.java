package com.residencia.dell.controllers;


import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrdersServices;
import com.residencia.dell.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ordersVO")
public class OrdersVOController {

    @Autowired
    OrdersServices ordersService;

    @GetMapping("/{id}")
    public ResponseEntity<OrdersVO> findById(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.findByIdVO(id),headers, HttpStatus.OK);}


    //****************************************************************************************************************

    @GetMapping("/{")
    public ResponseEntity findAll(
            @RequestParam(required = false)Integer  pagina,
            @RequestParam(required = false)Integer qtdRegistros)
            throws Exception{
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(ordersService.findAll(pagina, qtdRegistros),headers,HttpStatus.OK);
    }

//****************************************************************************************************************



//    @GetMapping("/listar-todos")
//    public ResponseEntity<List<OrderVO>>findAllvo(
//            @RequestParam(required = false)Integer pagina,
//            @RequestParam(required = false)Integer qtdRegistros)
//            throws Exception{
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<>(ordersService.findAllvo(pagina, qtdRegistros)),headers,HttpStatus.Ok);


    //****************************************************************************************************************

    @PostMapping
    public ResponseEntity<OrdersVO>Save (@RequestBody OrdersVO ordersVO){
        HttpHeaders headers = new HttpHeaders();

        OrdersVO novoOrdersVO = ordersService.saveVO(ordersVO);

        if(null!=novoOrdersVO){
            return new ResponseEntity<>(novoOrdersVO, headers, HttpStatus.OK);}
        else{
            return new ResponseEntity<>(novoOrdersVO,headers,HttpStatus.BAD_REQUEST);
        }

    }
    //****************************************************************************************************************
    @PutMapping

    public Orders update(Integer Id,Orders orders ){
        return  ordersService.update(Id, orders);
    }

    //****************************************************************************************************************
    @DeleteMapping

    public ResponseEntity<OrdersVO>delete(@RequestParam Integer id){
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

