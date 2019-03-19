package com.tgy.springboot2.xbook.springboot2xbookc4;

import org.springframework.stereotype.Service;

/**
 * @ClassName UserValidatorImpl
 */
@Service
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidatorImpl.class.getName());
        return user != null;
    }
}
