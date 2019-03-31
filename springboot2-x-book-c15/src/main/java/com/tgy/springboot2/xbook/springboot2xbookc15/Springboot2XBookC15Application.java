package com.tgy.springboot2.xbook.springboot2xbookc15;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan("com.tgy.springboot2.xbook.springboot2xbookc15.dao")
public class Springboot2XBookC15Application extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2XBookC15Application.class, args);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("admin")
                .password(passwordEncoder.encode("abc"))
                .roles("USER","ADMIN")
                .and()
                .withUser("myuser")
                .password(passwordEncoder.encode("123456"))
                .roles("USER");
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] endPoints = {"beans","mappings","shutdown"};

        http.requestMatcher(EndpointRequest.to(endPoints))
                .authorizeRequests().anyRequest()
                .hasAnyRole("ADMIN")
                .and()
                .antMatcher("/close")
                .authorizeRequests().anyRequest().hasRole("ADMIN")
                .and()
                .httpBasic();

    }*/



}
