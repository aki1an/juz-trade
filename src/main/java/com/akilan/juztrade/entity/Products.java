package com.akilan.juztrade.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Products {

    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private String ownerId;
    private String category;
    private String noOfSales;
    private float price;
    private String inStock;
    private String[] images;
    private String description;


    public Products(Long productId, String productName, String ownerId, String category, String noOfSales, float price, String inStock, String[] images, String description) {
        this.productId = productId;
        this.productName = productName;
        this.ownerId = ownerId;
        this.category = category;
        this.noOfSales = noOfSales;
        this.price = price;
        this.inStock = inStock;
        this.images = images;
        this.description = description;
    }

    public String getInStock() {
        return inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Products() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNoOfSales() {
        return noOfSales;
    }

    public void setNoOfSales(String noOfSales) {
        this.noOfSales = noOfSales;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String isInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
