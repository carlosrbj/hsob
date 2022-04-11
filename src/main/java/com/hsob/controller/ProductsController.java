package com.hsob.controller;

import com.hsob.model.products.Product;
import com.hsob.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")

public class ProductsController {
    @Autowired
    protected ProductsService productsService;

    public ResponseEntity createProduct(@RequestBody Product product,
                                        @RequestHeader String password,
                                        @RequestHeader String username){
        try {
            productsService.saveNewProduct(product, password, username);
            return ResponseEntity.ok().build();
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
