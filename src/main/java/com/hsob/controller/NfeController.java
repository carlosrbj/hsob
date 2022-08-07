package com.hsob.controller;

import com.hsob.model.nfe.NfeModel;
import com.hsob.model.nfe.QrcodeModel;
import com.hsob.service.NfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nfe")
public class NfeController {
    @Autowired
    NfeService nfeService;

    @GetMapping
    public ResponseEntity readNfe(@RequestBody QrcodeModel qrcode){
        try {
            NfeModel nfeModel = nfeService.readNfe(qrcode);
            return ResponseEntity.ok("Categoria criada: " + nfeModel);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
