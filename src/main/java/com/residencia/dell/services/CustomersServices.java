package com.residencia.dell.services;


import com.residencia.dell.entities.Customers;

import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersServices {
    @Autowired
    public CustomersRepository customersRepository;


//********************************************************************************************************************

    public Customers findById (Integer id){
        Customers newCustomers = customersRepository.findById(id).get();
        return newCustomers;
    }

    public CustomersRepository getCustomersRepository() {
        return customersRepository;
    }

    public void setCategoriesRepository(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }
//********************************************************************************************************************

    public List<Customers> findAll(Integer id){
        return customersRepository.findAll();
    }


    public List<Customers> findAll(Integer pagina, Integer qtdRegistros)throws Exception{
        Pageable page = null;
        List<Customers>listCustomers = null;
        List<Customers>listCustomersComPaginacao=null;

        try{

            if (null!= pagina && null!= qtdRegistros){
                page = PageRequest.of(pagina, qtdRegistros);
                listCustomersComPaginacao= customersRepository.findAll(page).getContent();
                return listCustomersComPaginacao;
            }
            else{
                listCustomers=customersRepository.findAll();

                return listCustomers;
            }


        } catch (Exception e) {
            throw new Exception("Não foi possivel recuperar a lista de pedidos::"+e.getMessage());
        }

    }
//********************************************************************************************************************

    public long count() { return customersRepository.count();}

//********************************************************************************************************************

    public Customers save (Customers customers){
        Customers newCustomers = customersRepository.save(customers);
        if(newCustomers.getCustomerId()!=null){
            return newCustomers;
        }
        else{ return null; }

    }

//********************************************************************************************************************

    public Customers update(Customers customers ){

        return customersRepository.save(customers);
    }

    public boolean delete(Integer id) {
        if (id != null) {
            customersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
