package com.hsob.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private TokenService tokenService;
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    @Override /*configurações de Autenticação*/
    protected void configure(@Autowired AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override /*Configuraçoes de Autorização*/
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/*").permitAll()
                .antMatchers(HttpMethod.GET,"/serviceStatus").permitAll()
                .antMatchers(HttpMethod.POST,"/api/users/saveUser").permitAll()
                .antMatchers(HttpMethod.POST,"/api/categories/new-category").permitAll()
                .antMatchers(HttpMethod.GET,"/api/categories/get-list").permitAll()
                .antMatchers(HttpMethod.GET,"/api/products/get-list").permitAll()
                .antMatchers(HttpMethod.GET,"/api/products/get-all").permitAll()
                .antMatchers(HttpMethod.POST,"/api/products/new-product").permitAll()
                .antMatchers(HttpMethod.POST,"/api/auth").permitAll()
                .antMatchers(HttpMethod.GET,"/actuator/**").permitAll()
                .anyRequest().authenticated() /*qualquer requisição elem das declaradas acima precisa de autenticação*/
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AuthenticationWithTokenFilter(tokenService), UsernamePasswordAuthenticationFilter.class); /*usa o formulário de autenticação gerado pelo spring*/
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }
}
