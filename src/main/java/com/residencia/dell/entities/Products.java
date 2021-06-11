package com.residencia.dell.entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Column(name = "prod_id", nullable = false)
    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    @NotNull(message = "Preencha a categoria corretamente.")
    @Range(min = 1, max = 16, message = "Tamanho mínimo: 1 / Tamanho máximo: 16")
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
    @Size(min = 1, max = 50, message = "Tamanho mínimo: 1 / Tamanho máximo: 50")
    @Column(name = "actor", nullable = false, length = 50)
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @NotNull(message = "Preencha o preço corretamente.")
    @DecimalMin(value = "1", message = "O preço não pode ser menor que R${value}.00")
    @DecimalMax(value = "1000", message = "O preço não pode ser maior que R${value}.00")
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
