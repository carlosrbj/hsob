package com.hsob.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class AuthenticationWithTokenFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    public AuthenticationWithTokenFilter(TokenService tokenService){
        this.tokenService = tokenService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = recoverToken(request);
        boolean valid = tokenService.isTokenValid(token);
        System.out.println(token);
        System.out.println(valid);

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer")){
            return null;
        }
        return token.substring(7);
    }
}
