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

    @Autowired
    private ProductsService productsService;
    @Autowired
    private UserService userAuthenticator;
    @Autowired
    private FileHelper fileHelper;

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
                .forEach(image-> {
                    fileHelper.writeFile(image, image.getOriginalFilename());
                    paths.add(
                            ServletUriComponentsBuilder
                                    .fromCurrentContextPath()
                                    .path("/image/"+image.getOriginalFilename())
                                    .toUriString());
                });
        Products targetProduct = productsService.ProductsById(productId).get();
        targetProduct.setImages(paths.toArray(new String[0]));
        productsService.createProducts(targetProduct);
        return ResponseEntity.ok().body(targetProduct);
    }


}
