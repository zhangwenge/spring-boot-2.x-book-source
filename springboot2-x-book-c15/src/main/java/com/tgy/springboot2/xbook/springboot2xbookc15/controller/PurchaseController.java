package com.tgy.springboot2.xbook.springboot2xbookc15.controller;

import com.tgy.springboot2.xbook.springboot2xbookc15.bo.ResultBo;
import com.tgy.springboot2.xbook.springboot2xbookc15.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName PurchaseController
 */
@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @GetMapping( "/test" )
    public ModelAndView testPage() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping( "/testJsp" )
    public ModelAndView testJsp() {
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }



    @PostMapping("/purchase")
    public ResultBo purchase(Long userId,Long productId,Integer quantity){
        boolean success = purchaseService.purchase(userId,productId,quantity);
        String message = success ? "抢购成功" : "抢购失败";
//        System.out.println(message);
        ResultBo resultBo = new ResultBo(success,message);
        return resultBo;
    }

}
