package com.hsob.controller;

import com.hsob.model.products.Category;
import com.hsob.model.products.Product;
import com.hsob.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductsController {
    @Autowired
    protected ProductsService productsService;

    @PostMapping("new-product")
    public ResponseEntity createProduct(@RequestBody Product product,
                                        @RequestHeader String password,
                                        @RequestHeader String username){
        try {
            productsService.saveNewProduct(product, password, username);
            return ResponseEntity.ok("Produto " + product.getName()+ " criado.");
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("get-list")
    public ResponseEntity getProductByCategory(@RequestParam String categoryId,
                                               @RequestHeader String password,
                                               @RequestHeader String username){
        try {
            List<Product> productList = productsService.getProductByCategory(categoryId, password, username);
            return ResponseEntity.ok(productList);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
