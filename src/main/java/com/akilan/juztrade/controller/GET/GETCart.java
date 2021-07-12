package com.akilan.juztrade.controller.GET;

import com.akilan.juztrade.entity.Cart;
import com.akilan.juztrade.service.CartService;
import com.akilan.juztrade.service.ProductsService;
import com.akilan.juztrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class GETCart {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductsService productsService;

    @GetMapping("/cart")
    public ResponseEntity getCart(@RequestParam("userId")String userId,
                                  @RequestParam("password")String password){
        //auth validation
        if(!userService.isValidUser(userId,password))
            return ResponseEntity.badRequest().body("auth failed");

        //skeleton for the cart response

        HashMap cartWithItems = new HashMap();
        //stores the productEntity
        List products = new ArrayList();
        //get the target cart by userId
        Cart targetCart  = cartService.getUsersCart(userId).get();
        //adding the product to the productList
        List<String> productList = Arrays.asList(targetCart.getProducts());
        productList.forEach(product->{
            products.add(productsService.ProductsById(Long.valueOf(product)).get());
        });
        cartWithItems.put("userId",userId);
        cartWithItems.put("products",products);
        cartWithItems.put("totalCost",targetCart.getTotalcost());

        return ResponseEntity.ok().body(cartWithItems);
    }

}
