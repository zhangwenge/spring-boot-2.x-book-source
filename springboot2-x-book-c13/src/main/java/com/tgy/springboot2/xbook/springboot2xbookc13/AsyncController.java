package com.tgy.springboot2.xbook.springboot2xbookc13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AsyncController
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public Object asyncPage(){
        asyncService.generateReport();
        System.out.println("先返回页面了");
        return "async";
    }
}
