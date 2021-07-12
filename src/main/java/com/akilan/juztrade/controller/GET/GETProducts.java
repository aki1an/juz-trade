package com.akilan.juztrade.controller.GET;

import com.akilan.juztrade.entity.Products;
import com.akilan.juztrade.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GETProducts {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/products/all")
    public Object allProducts(){
        return productsService.findAllProducts();
    }

    @GetMapping("/products")
    public Object productsFilterByCategory(@RequestParam(value = "category")String category){
        return productsService.ProductsByCategory(category);
    }

    @GetMapping("products/{id}")
    public Products fetchProductById(@PathVariable("id")long id){
        return productsService.ProductsById(id).get();
    }

    @GetMapping("products/owner/{owner}")
    public Object fetchProductsByOwner(@PathVariable("owner")String ownerId){
        return productsService.ProductsByOwnerId(ownerId);
    }
}
