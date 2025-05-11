package com.example.bridge_email_server.config;

import com.example.bridge_email_server.exceptions.AsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class GmailAsyncConfig implements AsyncConfigurer {
    @Bean
    public ThreadPoolTaskExecutor gmailTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("GmailThread-");
        //executor.setRejectedExecutionHandler((r, executor1) -> log.warn("Task rejected, thread pool is full and queue is also full"));
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }
}
