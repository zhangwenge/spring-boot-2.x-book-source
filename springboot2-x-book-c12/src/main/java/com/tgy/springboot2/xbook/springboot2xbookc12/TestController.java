package com.tgy.springboot2.xbook.springboot2xbookc12;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName TestController
 */
@RestController
public class TestController {

        @GetMapping("/user")
        public Object user(User user, HttpSession session){
            System.out.println(session.getId());
            return user;
        }
}
