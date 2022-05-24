package com.hsob.security;

import com.hsob.model.forum.UserForum;
import com.hsob.repository.DAO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Signature;
import java.util.Date;

@Service
public class TokenService extends DAO {

    @Value("${forum.jwt.expiration}")
    private  String expiration;
    @Value("${forum.jwt.secret}")
    private String secret;


    public String generateToken(Authentication authentication) {
//        UserForum userForum = (UserForum) authentication.getPrincipal();
        Date now = new Date();
        Date expirationTime = new Date(now.getTime() + Long.parseLong(expiration));
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        return Jwts.builder().setIssuer("Api H.S.O.B.")
                .setSubject(authentication.getPrincipal().toString())
                .setIssuedAt(now)
                .setExpiration(expirationTime)
                .signWith(signatureAlgorithm,secret)
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
