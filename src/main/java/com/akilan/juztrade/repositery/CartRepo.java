package com.akilan.juztrade.repositery;

import com.akilan.juztrade.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart,String> {

}
