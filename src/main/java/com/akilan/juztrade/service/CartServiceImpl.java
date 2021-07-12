package com.akilan.juztrade.service;

import com.akilan.juztrade.entity.Cart;
import com.akilan.juztrade.repositery.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepo cartRepo;

    @Override
    public Optional<Cart> getUsersCart(String userId) {
        return cartRepo.findById(userId);
    }

    @Override
    public void createCart(Cart cart) {
         cartRepo.save(cart);
    }
}
