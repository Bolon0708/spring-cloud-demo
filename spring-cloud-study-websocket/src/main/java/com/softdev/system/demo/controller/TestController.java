package com.softdev.system.demo.controller;

import com.softdev.system.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @ClassName: TestController
 * @Author: liangbl
 * @Date: 2020/7/30 14:28
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    ApplicationContext context;

    @Autowired
    private TestService testService;

    // @GetMapping("/test")
    // public void test() throws InterruptedException {
    //     testService.asyncA();
    //     testService.asyncB();
    // }

    @RequestMapping("/test")
    public void test() throws InterruptedException {
        int count = 10;
        try {
            CountDownLatch ctl = new CountDownLatch(count);
            TestController controller = context.getBean(TestController.class);
            controller.asyncA(ctl);
            controller.asyncB(ctl);
            controller.asyncA(ctl);
            controller.asyncB(ctl);
            int i=1/0;
            controller.asyncA(ctl);
            controller.asyncB(ctl);
            controller.asyncA(ctl);
            controller.asyncB(ctl);
            controller.asyncA(ctl);
            controller.asyncB(ctl);
            log.info("主线程等待");
            // ctl.await(10, TimeUnit.SECONDS);
            ctl.await(5, TimeUnit.SECONDS);
            log.info("主线程结束");
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
        }
    }

    @Async(value = "ThreadPoolA")
    public void asyncA(CountDownLatch ctl) throws InterruptedException {
        try {
            Thread.sleep(2000);
            log.info("a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ctl.countDown();
        }
    }

    @Async(value = "ThreadPoolB")
    public void asyncB(CountDownLatch ctl) throws InterruptedException {
            Thread.sleep(2000);
            log.info("b");
            // int i=1/0;
            ctl.countDown();
    }
}
