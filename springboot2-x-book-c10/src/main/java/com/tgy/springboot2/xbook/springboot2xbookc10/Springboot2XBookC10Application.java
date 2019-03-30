package com.tgy.springboot2.xbook.springboot2xbookc10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.io.File;

@SpringBootApplication
public class Springboot2XBookC10Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2XBookC10Application.class, args);
    }

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @PostConstruct
    public void initFileUploadPath() {
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new Interceptor1());
        interceptorRegistration.addPathPatterns("/interceptor/*");
    }
}
