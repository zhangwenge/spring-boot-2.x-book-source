package com.tgy.springboot2.xbook.springboot2xbookc4;


import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName Intereptor
 */
public interface Interceptor {
    boolean before();

    void after();

    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    void afterReturning();

    void afterThrowing();

    boolean userAround();
}
