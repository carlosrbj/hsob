package com.hsob.controller;

import com.hsob.model.users.Address;
import com.hsob.model.users.User;
import com.hsob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.ok().build();
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
}
