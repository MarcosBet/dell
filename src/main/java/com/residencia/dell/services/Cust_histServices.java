package com.residencia.dell.services;


import com.residencia.dell.entities.Cust_hist;
import com.residencia.dell.repositories.Cust_histRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cust_histServices {
    @Autowired
    public Cust_histRepository cust_histRepository;

//********************************************************************************************************************

    public Cust_hist findById (Integer id){
        Cust_hist novoCategories = cust_histRepository.findById(id).get();
        return novoCategories;
    }

//********************************************************************************************************************

    public List<Cust_hist> findAll(Integer id){

        return cust_histRepository.findAll();
    }

//********************************************************************************************************************

    public long count() {
        return cust_histRepository.count();}

//********************************************************************************************************************

    public Cust_hist save(Cust_hist cust_hist) {

        return cust_histRepository.save(cust_hist);
    }

//********************************************************************************************************************

    public Cust_hist update(Cust_hist cust_hist ){

        return cust_histRepository.save(cust_hist);
    }

    public boolean delete(Integer id) {
        if (id != null) {
            cust_histRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
