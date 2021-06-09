package com.residencia.dell.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prod_id")
    private Integer prodId;






    @Column(name = "category")
    private Calendar category ;

    @Column(name = "title")
    private String title;

    @Column(name = "actor")
    private String actor;

    @Column(name = "price")
    private Integer price;

    @Column(name = "special")
    private Integer special;

    @Column(name = "commonprodid")
    private Integer commonprodid;

    public Integer getProd_id() {
        return prodId;
    }

    public void setProd_id(Integer prod_id) {
        this.prodId = prodId;
    }

    public Calendar getCategory() {
        return category;
    }

    public void setCategory(Calendar category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Integer getPrince() {
        return price;
    }

    public void setPrince(Integer prince) {
        this.price = prince;
    }

    public Integer getSpecial() {
        return special;
    }

    public void setSpecial(Integer special) {
        this.special = special;
    }

    public Integer getCommon() {
        return commonprodid;
    }

    public void setCommon(Integer common) {
        this.commonprodid = common;
    }
}
