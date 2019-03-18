package com.tgy.springboot2.xbook.springboot2xbookc4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyAspect
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.tgy.springboot2.xbook.springboot2xbookc4.UserServiceImpl.printUser(..))")
    public void pointCut(){

    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pj) throws Throwable{
        Object[] args = pj.getArgs();
        System.out.println("around before");
        Object proceed = pj.proceed();
        System.out.println("around after");
        return proceed;
    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after");
    }
    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning");
    }

}
