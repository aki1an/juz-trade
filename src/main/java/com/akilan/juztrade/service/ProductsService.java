package com.akilan.juztrade.service;

import com.akilan.juztrade.entity.Products;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    public List<Products> ProductsByCategory(String Category);

    public List<Products> ProductsByOwnerId(String OwnerId);

    public Optional<Products> ProductsById(Long ProductId);

    boolean createProducts(Products products);

    List<Products> findAllProducts();

    void deleteProductById(Products product);
}
