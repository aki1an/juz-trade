package com.akilan.juztrade.service;

import com.akilan.juztrade.entity.Cart;

import java.util.Optional;

public interface CartService {
    public Optional<Cart> getUsersCart(String userId);

    public void createCart(Cart cart);
}
