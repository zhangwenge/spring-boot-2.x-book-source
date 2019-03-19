package com.tgy.springboot2.xbook.springboot2xbookc4;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class Springboot2XBookC4Application {

   /* @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Springboot2XBookC4Application.class, args);
    }

}
