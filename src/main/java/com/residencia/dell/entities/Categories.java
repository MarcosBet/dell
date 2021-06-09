package com.residencia.dell.entities;


import javax.persistence.*;

@Entity
@Table(name="categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category")
    private Integer category;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

//*************************************************************************************************************

    @Column(name = "categoryname")
    private Character categoryName;




    public Character getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Character categoryName) {
        this.categoryName = categoryName;
    }




//*************************************************************************************************************


}
