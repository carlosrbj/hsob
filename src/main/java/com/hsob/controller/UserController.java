package com.hsob.controller;

import com.hsob.model.users.User;
import com.hsob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public User save(@RequestBody User user, @RequestParam String password){
        return userService.saveUser(user, password);
    }
}
