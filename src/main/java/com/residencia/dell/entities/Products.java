package com.residencia.dell.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Products {
    private Integer prodId;
    private Integer category;
    private String title;
    private String actor;
    private BigDecimal price;
    private Short special;
    private Integer commonProdId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id")
    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    @Column(name = "category")
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @NotBlank(message = "Preencha o título corretamente.")
    @Size(min = 1, max = 50, message = "Tamanho mínimo: 1 / Tamanho máximo: 50")
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotBlank(message = "Preencha o ator corretamente.")
    @Size(min = 1, max = 50, message = "Tamanho mínimo: 1\nTamanho máximo: 50")
    @Column(name = "actor", nullable = false, length = 50)
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @DecimalMin(value = "1", message="O preço não pode ser menor que R${value}.00")
    @DecimalMax(value = "1000", message="O preço não pode ser maior que R${value}.00")
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "special")
    public Short getSpecial() {
        return special;
    }

    public void setSpecial(Short special) {
        this.special = special;
    }

    @Column(name = "common_prod_id")
    public Integer getCommonProdId() {
        return commonProdId;
    }

    public void setCommonProdId(Integer commonProdId) {
        this.commonProdId = commonProdId;
    }
}
