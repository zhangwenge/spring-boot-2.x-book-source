package com.tgy.springboot2.xbook.springboot2xbookc15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName T二十天
 */
//@Controller
public class TsetController {


    @RequestMapping("/test")
    public String testPage() {
        return "index";
    }
}
