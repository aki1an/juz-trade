package com.akilan.juztrade.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Cart {
    @Id
    private String userId;
    private String[] products;
    private double totalcost;

    public Cart() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getProducts() {
        return products;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }

    public Cart(String userId, String[] products, double totalcost) {
        this.userId = userId;
        this.products = products;
        this.totalcost = totalcost;
    }
}
