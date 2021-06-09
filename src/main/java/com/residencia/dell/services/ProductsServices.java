package com.residencia.dell.services;


import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServices {


    @Autowired
    public ProductsRepository productsRepository;


//********************************************************************************************************************

    public Products findById (Integer id){
        Products newProducts = productsRepository.findById(id).get();
        return newProducts;
    }


//********************************************************************************************************************

    public List<Products> findAll(Integer id){

        return productsRepository.findAll();
    }

//********************************************************************************************************************

    public long count() { return productsRepository.count();}

//********************************************************************************************************************

    public Products save (Products products){
        Products newProducts = productsRepository.save(products);
        if(newProducts.getProd_id()!=null){
            return newProducts;
        }
        else{ return null; }

    }

//********************************************************************************************************************

    public Products update(Products products){

        return productsRepository.save(products);
    }
//********************************************************************************************************************


    public boolean delete(Integer id) {
        if (id != null) {
            productsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
