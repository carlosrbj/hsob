package com.hsob.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autentication(@RequestBody @Valid LoginForm loginForm){
        UsernamePasswordAuthenticationToken userToken = loginForm.convert();
        try {
            String token = tokenService.generateToken(userToken);
            System.out.println(token);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

    }
}
