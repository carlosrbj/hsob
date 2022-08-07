package com.hsob.controller;

import com.hsob.Utils;
import com.hsob.model.products.Category;
import com.hsob.model.products.Product;
import com.hsob.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductsController {
    @Autowired
    protected ProductsService productsService;

    @PostMapping("new-product")
    public ResponseEntity createProduct(@RequestBody List<Product> products,
                                        @RequestHeader String password,
                                        @RequestHeader String username){
        try {
            productsService.saveNewProduct(products, password, username);
            return ResponseEntity.ok("Produtos criados.");
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("get-list")
    public ResponseEntity getProductByCategoryName(@RequestParam String categoryName,
                                               @RequestHeader String password,
                                               @RequestHeader String username){
        try {
            List<Product> productList = productsService.getProductByCategory(categoryName, password, username);
            return ResponseEntity.ok(productList);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("get-all")
    public ResponseEntity getAllProducts(@RequestHeader String password,
                                         @RequestHeader String username){
        try {
            List<Product> productList = productsService.getAllProduct(password, username);
            return ResponseEntity.ok(productList);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }


}
