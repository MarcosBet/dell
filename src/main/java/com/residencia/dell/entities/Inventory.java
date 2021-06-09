package com.residencia.dell.entities;

import javax.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "prod_id")
    private Integer prodId;

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }




//***************************************************************************************************

 //    @OneToMany
 //    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
 //    private Products products;
//      ou
 //    (mappedBy="prod_id")
 //***************************************************************************************************



 //************************************************************************************************************
    @Column(name="quan_in_stock")
    private Integer quanInStock;

    public Integer getQuanInStock() {
        return quanInStock;
    }

    public void setQuanInStock(Integer quanInStock) {
        this.quanInStock = quanInStock;
    }

    //************************************************************************************************************
    @Column(name ="sales")
    private Integer sales;

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }


}
