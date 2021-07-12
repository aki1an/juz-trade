package com.akilan.juztrade.controller.POST;

import com.akilan.juztrade.entity.Cart;
import com.akilan.juztrade.service.CartService;
import com.akilan.juztrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Cart_POST {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;


    @PostMapping("/cart")
    public ResponseEntity postCart(@RequestParam("userId") String userId,
                                   @RequestParam("password") String password,
                                   @RequestBody Cart cart) {

        cartService.createCart(cart);
        return ResponseEntity.accepted().body("cart created");
    }

    @PutMapping("/cart/add")
    public ResponseEntity addItemsToCart(@RequestParam("userId") String userId,
                                         @RequestParam("password") String password,
                                         @RequestParam("productId") String productId) {

        if (!userService.isValidUser(userId, password))
            return ResponseEntity.badRequest().body("no such users");

        Cart targetCart = cartService.getUsersCart(userId).get();
        String products[] = new String[targetCart.getProducts().length+1];
        for (int i=0;i<targetCart.getProducts().length;i++)
        {
            products[i] = targetCart.getProducts()[i];
        }
        products[targetCart.getProducts().length]=productId;
        targetCart.setProducts(products);
        cartService.createCart(targetCart);
        return ResponseEntity.accepted().body(targetCart);
    }

    @DeleteMapping("/cart/removeItems")
    public ResponseEntity modifyCart(@RequestParam("userId") String userId,
                                     @RequestParam("password") String password,
                                     @RequestBody Cart cart){

        if(cart.getUserId().equals(userId))
            cartService.createCart(cart);
        else
            return ResponseEntity.badRequest().body("userid doesn't match");

        return ResponseEntity.accepted().body(cart);
    }


}
