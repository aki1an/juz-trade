package com.akilan.juztrade.repositery;

import com.akilan.juztrade.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {

    @Query(value = "select * from products where category = :category", nativeQuery = true)
    List<Products> fetchProductsByCategory(@Param("category") String category);

    @Query(value = "select * from products where owner_Id = :ownerId", nativeQuery = true)
    List<Products> fetchProductsByOwnerId(@Param("ownerId") String ownerId);

}
