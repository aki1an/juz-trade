package com.akilan.juztrade.controller.POST;

import com.akilan.juztrade.entity.Products;
import com.akilan.juztrade.helpers.FileHelper;
import com.akilan.juztrade.service.ProductsService;
import com.akilan.juztrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Products_POST {

    private final ProductsService productsService;
    private final UserService userAuthenticator;
    private final FileHelper fileHelper;

    public Products_POST(ProductsService productsService, UserService userAuthenticator, FileHelper fileHelper) {
        this.productsService = productsService;
        this.userAuthenticator = userAuthenticator;
        this.fileHelper = fileHelper;
    }

    @PostMapping("/product/create")
    public ResponseEntity createProducts(@RequestParam("userId") String userId,
                                         @RequestParam("password") String password,
                                         @RequestBody Products products) {

        if (userAuthenticator.isValidUser(userId, password)) {
            productsService.createProducts(products);
            return ResponseEntity.accepted().body(products.getProductId());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/product/{productId}")
    public ResponseEntity setAssets(@RequestParam("userId") String userId,
                                    @PathVariable("productId") Long productId,
                                    @RequestParam("password") String password,
                                    @RequestParam("images") List<MultipartFile> images) {

        List<String> paths = new ArrayList();

        images
                .forEach(image -> {
                    fileHelper.writeFile(image, image.getOriginalFilename());
                    paths.add(
                            ServletUriComponentsBuilder
                                    .fromCurrentContextPath()
                                    .path("/image/" + image.getOriginalFilename())
                                    .toUriString());
                });
        Products targetProduct = productsService.ProductsById(productId).get();
        targetProduct.setImages(paths.toArray(new String[0]));
        productsService.createProducts(targetProduct);
        return ResponseEntity.ok().body(targetProduct);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteUserById(@RequestParam("userId") String userId,
                                         @RequestParam("password") String password,
                                         @PathVariable("productId") Long productId) {
        System.out.println(productId);
        if (!userAuthenticator.isValidUser(userId, password))
            return ResponseEntity.badRequest().body("not authorized user " +
                    "\n " +
                    "permission denied");

        if (productsService.ProductsById(productId).isPresent()) {
            Products product = productsService.ProductsById(productId).get();
            productsService.deleteProductById(product);
            return ResponseEntity.ok("product deleted : " + productId);
        }

        return ResponseEntity.badRequest().body("no such product found");

    }


}
