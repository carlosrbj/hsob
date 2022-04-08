package com.hsob.controller;

import com.hsob.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    @Autowired
    SalesService salesService;

    @GetMapping("/getById")
    public ResponseEntity getSalesById(@RequestParam ("id") String id){
        String answer = salesService.getSalesById(id);

        return ResponseEntity.ok(answer);
    }
}
