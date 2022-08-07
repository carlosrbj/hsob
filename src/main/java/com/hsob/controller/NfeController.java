package com.hsob.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nfe")
public class NFEController {

    public ResponseEntity readNfe(@RequestHeader String qrcode){
        try {
            categoryService.createCategory(category, password, username);
            return ResponseEntity.ok("Categoria criada: " + category);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
