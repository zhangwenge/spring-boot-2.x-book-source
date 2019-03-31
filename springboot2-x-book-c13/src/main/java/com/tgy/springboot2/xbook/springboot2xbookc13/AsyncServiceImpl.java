package com.tgy.springboot2.xbook.springboot2xbookc13;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName AsyncServiceImpl
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async
    public void generateReport() {
        System.out.println("报表线程名称： " + Thread.currentThread().getName());
        try {
            System.out.println("开始生成报表");
            Thread.sleep(3000);
            System.out.println("报表生成结束");
        } catch (InterruptedException e) {
            System.out.println("报表成成异常，写入数据库记录了");
            e.printStackTrace();
        }
    }
}
