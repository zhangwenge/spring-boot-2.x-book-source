package com.tgy.springboot2.xbook.springboot2xbookc4;

import java.lang.reflect.InvocationTargetException;

/**
 * 描述：
 * @author tianGuiYin      
 * @date：2019/3/19 0:01
 */
public class MyIntereptor implements Interceptor {

    @Override
    public boolean before() {
        System.out.println("before");
        return false;
    }

    @Override
    public void after() {
        System.out.println("after");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before");
        Object obj = invocation.procced();
        System.out.println("around after");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Override
    public boolean userAround() {
        return true;
    }
}
