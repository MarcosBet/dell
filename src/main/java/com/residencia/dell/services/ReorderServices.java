package com.residencia.dell.services;


import com.residencia.dell.entities.Reorder;
import com.residencia.dell.repositories.ReorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReorderServices {


    @Autowired
    public ReorderRepository reorderRepository;


//********************************************************************************************************************

    public Reorder findById (Integer id){
        Reorder newReorder = reorderRepository.findById(id).get();
        return newReorder;
    }


//********************************************************************************************************************

    public List<Reorder> findAll(Integer id){

        return reorderRepository.findAll();
    }

//********************************************************************************************************************

    public long count() { return reorderRepository.count();}

//********************************************************************************************************************

    public Reorder save (Reorder reorder){
        Reorder newProducts = reorderRepository.save(reorder);
        if(newProducts.getProdId()!=null){
            return newProducts;
        }
        else{ return null; }

    }

//********************************************************************************************************************

    public Reorder update(Reorder reorder){

        return reorderRepository.save(reorder);
    }

    public boolean delete(Integer id) {
        if (id != null) {
            reorderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
