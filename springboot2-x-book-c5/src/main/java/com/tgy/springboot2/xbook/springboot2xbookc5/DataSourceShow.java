package com.tgy.springboot2.xbook.springboot2xbookc5;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceShow
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("-----------------------------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("-----------------------------------");
    }
}
