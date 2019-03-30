package com.tgy.springboot2.xbook.springboot2xbookc4;

import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void printUser(User user) {
        if (user.getId() == null) {
            throw new RuntimeException("检查用户参数是否为空");
        }
        System.out.println("id:" + user.getId());
        System.out.println("userName:" + user.getUserName());
        System.out.println("noge:" + user.getNote());
    }
}
