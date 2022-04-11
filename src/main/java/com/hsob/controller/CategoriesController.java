package com.hsob.controller;

import com.hsob.model.products.Category;
import com.hsob.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    protected CategoryService categoryService;

    @PostMapping("new-category")
    public ResponseEntity createCategory(@RequestParam String category,
                                         @RequestHeader String password,
                                         @RequestHeader String username){
        try {
            categoryService.createCategory(category, password, username);
            return ResponseEntity.ok("Categoria criada: " + category);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("get-list")
    public ResponseEntity getCategoriesList(@RequestHeader String password,
                                            @RequestHeader String username){
        try {
            List<Category> categoriesList = categoryService.getCategoriesList(password, username);
            return ResponseEntity.ok(categoriesList);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
