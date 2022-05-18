package com.hsob.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
    @Override /*configurações de Autenticação*/
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }

    @Override /*Configuraçoes de Autorização*/
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/*").permitAll();
    }

    @Override /*Configurações de recursos web*/
    public void configure(WebSecurity web) throws Exception {
    }
}
