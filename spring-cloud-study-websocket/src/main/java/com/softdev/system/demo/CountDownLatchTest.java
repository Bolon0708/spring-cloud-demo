package com.softdev.system.demo;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @ClassName: CountDownLatch
 * @Author: liangbl
 * @Date: 2020/7/30 14:04
 */
public class CountDownLatchTest {

    /**
     * 初始化CountDownLatch，值为线程数量
     */
    private static final CountDownLatch CTL = new CountDownLatch(10);

    public static void main(String[] args) throws Exception {
        System.out.println("主线程正在执行前：" + Thread.currentThread().getName());
        test3();
        //最多等待20秒，不管子线程完没完
        CTL.await(1, TimeUnit.SECONDS);
        System.out.println("主线程正在执行后：" + Thread.currentThread().getName());
    }


    private static void test3() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(100);
                new Thread(() -> {
                    System.out.println("子线程正在执行:" + Thread.currentThread().getName());
                }).start();
                CTL.countDown();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
