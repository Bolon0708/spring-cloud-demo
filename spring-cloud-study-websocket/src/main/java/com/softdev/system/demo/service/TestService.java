package com.softdev.system.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @ClassName: TestService
 * @Author: liangbl
 * @Date: 2020/7/30 14:29
 */
@Service
@Slf4j
public class TestService {

    @Async(value = "ThreadPoolA")
    public void asyncA() throws InterruptedException {
        Thread.sleep(1000);
        log.info("a");
    }

    @Async(value = "ThreadPoolB")
    public void asyncB() throws InterruptedException {
        Thread.sleep(1000);
        log.info("b");
    }
}
