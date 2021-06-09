package com.residencia.dell.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="orderlines")

public class Orderlines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderlineid")
    private Integer orderLineId;
//***************************************************************************************************




    // anotações de chaves   relação
    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    private Orders orders;

//***************************************************************************************************





    @Column(name = "prod_id")
    private Integer prodId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "orderdate")
    private Calendar orderDate;




    public Integer getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
    }


    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }


}
