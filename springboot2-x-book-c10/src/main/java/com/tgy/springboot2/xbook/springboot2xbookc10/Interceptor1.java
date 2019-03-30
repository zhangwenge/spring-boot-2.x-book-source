package com.tgy.springboot2.xbook.springboot2xbookc10;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Interceptor1
 */
public class Interceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("处理器前方法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("处理器后方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("处理器完成方法");
        if (ex instanceof ArithmeticException) {
            response.sendRedirect("http://www.baidu.com");
            return;
        } else if (ex instanceof NullPointerException) {
            response.sendRedirect("http://www.qq.com");
            return;
        }
    }
}
