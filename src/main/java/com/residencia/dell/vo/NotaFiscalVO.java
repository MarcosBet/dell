package com.residencia.dell.vo;

import java.util.Calendar;
import java.util.List;

public class NotaFiscalVO {
    private  Integer orderId;
    private Calendar orderDate;
    private Integer netAmount;
    private Integer totalAmount;
    private String customerFirstName;
    private String customerLastname;
    private List<ItemOrderlineVO> listItemOrderlinesVO;

    public Integer getOrderId() {
        return orderId;
    }



    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Integer netAmount) {
        this.netAmount = netAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public List<ItemOrderlineVO> getListItemOrderlinesVO() {
        return listItemOrderlinesVO;
    }

    public void setListItemOrderlineVO(List<ItemOrderlineVO> listItemOrderlinesVO) {
        this.listItemOrderlinesVO = listItemOrderlinesVO;
    }
}
