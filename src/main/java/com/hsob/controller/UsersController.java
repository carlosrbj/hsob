package com.hsob.controller;

import com.hsob.Utils;
import com.hsob.model.users.Address;
import com.hsob.model.users.User;
import com.hsob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author carlos
 */

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity save(@RequestBody User user, @RequestHeader String password, @RequestHeader String confirmPassword){
        try {
            userService.saveUser(user, password, confirmPassword);
            return ResponseEntity.ok("User saved.");
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @PutMapping("/updateAddress")
    public ResponseEntity update(@RequestBody Address address, @RequestHeader String password, @RequestHeader String username){
        try {
            userService.updateAddress(address, password, username);
            return ResponseEntity.ok("Address updated");
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @PostMapping("save-image")
    public ResponseEntity saveImage(@RequestPart MultipartFile file, @RequestPart String username) throws IOException {
        userService.imageTo64Base(file, username);
        return ResponseEntity.ok().build();
    }
}
