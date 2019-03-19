package com.tgy.springboot2.xbook.springboot2xbookc5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tgy.springboot2.xbook.springboot2xbookc5.dao")
public class Springboot2XBookC5Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2XBookC5Application.class, args);
    }

}
