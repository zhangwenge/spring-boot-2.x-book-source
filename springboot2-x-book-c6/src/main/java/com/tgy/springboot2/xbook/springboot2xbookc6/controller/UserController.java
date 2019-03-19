package com.tgy.springboot2.xbook.springboot2xbookc6.controller;

import com.tgy.springboot2.xbook.springboot2xbookc6.po.User;
import com.tgy.springboot2.xbook.springboot2xbookc6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public Object getUser(User user){
        User userR = userService.getUser(user.getId());
        return userR;
    }

    @RequestMapping("/insertUser")
    public Object insertUser(User user){
        int i = userService.insertUser(user);
        return i;
    }

}
