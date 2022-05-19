package com.hsob.security;

import com.hsob.model.forum.UserForum;
import com.hsob.repository.DAO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService extends DAO {

    @Value("${forum.jwt.expiration}")
    private  String expiration;
    @Value("${forum.jwt.secret}")
    private String secret;


    public String generateToken(Authentication authentication) {
        UserForum userForum = (UserForum) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder().setIssuer("Api H.S.O.B.")
                .setSubject(userForum.getUsername())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
}
