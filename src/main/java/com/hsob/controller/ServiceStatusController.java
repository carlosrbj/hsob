package com.hsob.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serviceStatus")
public class ServiceStatusController {

    @GetMapping()
    public String serviceStatus(){
       return "H.S.O.B. Service is running";

    }
}
