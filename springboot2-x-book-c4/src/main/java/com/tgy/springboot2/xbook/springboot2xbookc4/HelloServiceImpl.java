package com.tgy.springboot2.xbook.springboot2xbookc4;

import org.springframework.util.StringUtils;

/**
 * @ClassName HelloServiceImpl
 */
public class HelloServiceImpl implements HelloService {


    @Override
    public void sayHello(String name) {
        if(StringUtils.isEmpty(name)){
            throw new RuntimeException("name can not be null");
        }
        System.out.println("hello " + name);
    }
}
