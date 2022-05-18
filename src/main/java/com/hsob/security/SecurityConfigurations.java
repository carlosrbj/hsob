package com.hsob.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
    @Override /*configurações de Autenticação*/
    protected void configure(@Autowired AuthenticationManagerBuilder auth) throws Exception {
    }

    @Override /*Configuraçoes de Autorização*/
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/*").permitAll()
                .anyRequest().authenticated() /*qualquer requisição elem das declaradas acima precisa de autenticação*/
                .and().formLogin(); /*usa o formulário de autenticação gerado pelo spring*/
    }

    @Override /*Configurações de recursos web*/
    public void configure(WebSecurity web) throws Exception {
    }
}
