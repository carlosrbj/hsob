package com.hsob.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Document(collection = "user")
@Getter
@Setter
public class LoginForm {
    private String username;
    private String password;


    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
