package com.akilan.juztrade.service;

import com.akilan.juztrade.entity.Products;
import com.akilan.juztrade.repositery.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ProductsRepo productsRepo;
    @Override
    public List<Products> ProductsByCategory(String Category) {
        return productsRepo.fetchProductsByCategory(Category);
    }

    public List<Products> ProductsByOwnerId(String OwnerId) {
        return productsRepo.fetchProductsByOwnerId(OwnerId);
    }


    @Override
    public Optional<Products> ProductsById(Long ProductId) {
        return productsRepo.findById(ProductId);
    }

    @Override
    public boolean createProducts(Products products) {
        productsRepo.save(products);
        return true;
    }

    @Override
    public List<Products> findAllProducts() {
        return productsRepo.findAll();
    }
}
