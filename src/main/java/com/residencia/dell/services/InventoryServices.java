package com.residencia.dell.services;


import com.residencia.dell.entities.Inventory;
import com.residencia.dell.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServices {

    @Autowired
    public InventoryRepository inventoryRepository;


//********************************************************************************************************************

    public Inventory findById (Integer id){
        Inventory newInventory = inventoryRepository.findById(id).get();
        return newInventory;
    }

    public InventoryRepository getInventoryRepository() {
        return inventoryRepository;
    }

    public void setInventoryRepository(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
//********************************************************************************************************************

    public List<Inventory> findAll(Integer id){

        return inventoryRepository.findAll();
    }

//********************************************************************************************************************

    public long count() { return inventoryRepository.count();}

//********************************************************************************************************************

    public Inventory save (Inventory inventory){
        Inventory newInventory = inventoryRepository.save(inventory);
        if(newInventory.getProdId()!=null){
            return newInventory;
        }
        else{ return null; }

    }

//********************************************************************************************************************

    public Inventory update(Inventory inventory ){

        return inventoryRepository.save(inventory);
    }

    public boolean delete(Integer id) {
        if (id != null) {
            inventoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }





}
