package com.residencia.dell.vo;

import java.util.Calendar;

public class OrderlinesVO {
    private Integer orderlineid;
    private Integer ordersVO;
    private Integer prodId;
    private Integer quantity;
    private Calendar orderDate;

    public Integer getOrderlineid() {
        return orderlineid;
    }

    public void setOrderlineid(Integer orderlineid) {
        this.orderlineid = orderlineid;
    }

    public Integer getOrdersVO() {
        return ordersVO;
    }

    public void setOrdersVO(Integer ordersVO) {
        this.ordersVO = ordersVO;
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
