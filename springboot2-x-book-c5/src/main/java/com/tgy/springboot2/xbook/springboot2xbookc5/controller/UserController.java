package com.tgy.springboot2.xbook.springboot2xbookc5.controller;

import com.tgy.springboot2.xbook.springboot2xbookc5.pojo.User;
import com.tgy.springboot2.xbook.springboot2xbookc5.service.UserService;
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
    public User getUser(User user){
        User userR = userService.getUser(user.getId());
        return userR;
    }

}
