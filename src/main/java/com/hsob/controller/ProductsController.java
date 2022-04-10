package com.hsob.controller;

import com.hsob.model.products.Category;
import com.hsob.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @RequestMapping("new-category")
    public ResponseEntity createCategory(@RequestParam String category,
                                         @RequestHeader String password,
                                         @RequestHeader String username){
        try {
            productsService.createCategory(category, password, username);
            return ResponseEntity.ok().build();
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }

    }
}
