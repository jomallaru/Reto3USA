package com.example.Reto3.Security;


import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class SecurityAdapter extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http.authorizeRequests(
                a -> a.antMatchers("/", "/error", "/webjars/**", "/api/**" ).permitAll().anyRequest().authenticated()
        ).exceptionHandling(
                e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.FORBIDDEN)) //CODIGO 403
        ).oauth2Login().defaultSuccessUrl("/homePage.html" , true);
        http.cors().and().csrf().disable();

    }
}
