package com.tgy.springboot2.xbook.springboot2xbookc4;

/**
 * @ClassName MainObject
 */
public class MainObject {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyIntereptor());
        proxy.sayHello("tgy");
    }
}
