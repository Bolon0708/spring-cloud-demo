package com.softdev.system.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: TODO
 * @ClassName: ThreadPoolConfig
 * @Author: liangbl
 * @Date: 2020/7/30 14:27
 */
@Configuration
public class ThreadPoolConfig {
    /**
     * 线程池A用于xxx业务
     *
     * @return
     */
    @Bean(name = "ThreadPoolA")
    public ThreadPoolTaskExecutor ThreadPoolTaskExecutorAsyncPoolA() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //根据实际情况配置
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(60);
        //自定义线程名称前缀
        executor.setThreadNamePrefix("Pool-A");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;

    }

    /**
     * 线程池B用于xxx业务
     *
     * @return
     */
    @Bean(name = "ThreadPoolB")
    public ThreadPoolTaskExecutor ThreadPoolTaskExecutorAsyncPoolB() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //根据实际情况配置
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(8);
        executor.setKeepAliveSeconds(60);
        //自定义线程名称前缀
        executor.setThreadNamePrefix("Pool-B");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();

        return executor;

    }
}
