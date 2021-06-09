package com.residencia.dell.entities;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
@Table(name="cust_hist")
public class Cust_hist {

    @Id
    @Column(name = "customerid")
    private Integer customerId;


    @Column(name = "orderid")
    private Integer orderId;

    @Column(name = "prod_id")
    private Integer prodId;



//    @ManyToOne
//    @JoinColumn(name = "customerid", referencedColumnName = "custumerid")
//    private Customers customers;


//***************************************************************************************************







    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }
}

