package com.tgy.springboot2.xbook.springboot2xbookc6;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import java.util.Properties;

@SpringBootApplication
@MapperScan("com.tgy.springboot2.xbook.springboot2xbookc6.dao")
public class Springboot2XBookC6Application {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Springboot2XBookC6Application.class, args);
    }

    @PostConstruct
    public void showTransactionManager(){
        System.out.println("调整sqlSessionFactory");
        /*SqlSessionFactoryBean bean = applicationContext.getBean(SqlSessionFactoryBean.class);
        Properties properties = new Properties();
        properties.put("dialect","mysql");
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);
        Interceptor[] plugins = {pageInterceptor};
        bean.setPlugins(plugins);*/
    }



}
