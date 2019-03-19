package com.tgy.springboot2.xbook.springboot2xbookc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    public Object printUser(User user){
        UserValidator userValidator = (UserValidator)userService;
        if(userValidator.validate(user)){
            userService.printUser(user);
        }
        return user;
    }

}
