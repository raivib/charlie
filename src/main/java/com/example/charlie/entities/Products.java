package com.example.charlie.entities;

/*
Database defining methods for Products
 */

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@JsonDeserialize
public class Products {
@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String product;
    private String productCode;
    private int price;

/*
    public Products(int id, String product, String productCode, int price) {
        this.id=id;
        this.product=product;
        this.productCode=productCode;
        this.price=price;
    }


 */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
