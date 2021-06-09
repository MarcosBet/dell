package com.residencia.dell.services;

import com.residencia.dell.entities.Categories;
import com.residencia.dell.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriesServices {
    @Autowired
    public CategoriesRepository categoriesRepository;

//********************************************************************************************************************

    public Categories findById (Integer id){
        Categories novoCategories = categoriesRepository.findById(id).get();
        return novoCategories;
    }

    public CategoriesRepository getCategoriesRepository() {
        return categoriesRepository;
    }

    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }
//********************************************************************************************************************

    public List<Categories> findAll(Integer id, Character categoryname){
        return categoriesRepository.findAll();
    }

//********************************************************************************************************************

    public long count() { return categoriesRepository.count();}

//********************************************************************************************************************

    public Categories save (Categories categories){
        Categories newCategory = categoriesRepository.save(categories);
        if(newCategory.getCategory()!=null){
        return newCategory;
        }
        else{ return null; }

   }

//********************************************************************************************************************

    public Categories update(Categories categories ){

        return categoriesRepository.save(categories);
    }

    public boolean delete(Integer id) {
        if (id != null) {
            categoriesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }





}
