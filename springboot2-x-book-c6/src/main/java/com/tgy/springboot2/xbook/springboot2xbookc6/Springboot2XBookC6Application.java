package com.tgy.springboot2.xbook.springboot2xbookc6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.tgy.springboot2.xbook.springboot2xbookc6.dao")
public class Springboot2XBookC6Application {

    @Autowired
    private PlatformTransactionManager transactionManager;

    public static void main(String[] args) {
        SpringApplication.run(Springboot2XBookC6Application.class, args);
    }

    @PostConstruct
    public void showTransactionManager(){
        System.out.println("transactionManage's name");
        System.out.println(transactionManager.getClass().getName());
    }

}
