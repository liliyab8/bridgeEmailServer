package com.example.bridge_email_server.config;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.FutureTask;

@Configuration
@EnableAsync
public class YahooAsyncConfig implements AsyncConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(GmailAsyncConfig.class);
    @Bean (name = "yahooTaskExecutor")
    public ThreadPoolTaskExecutor yahooTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("YahooThread-");
        executor.setRejectedExecutionHandler((r, executor1) -> {
            logger.info("❌ Task was rejected. Reason: Yahoo thread pool exhausted.");
            if (r instanceof FutureTask) {
                logger.info("Rejected Yahoo task: " + r);
            }
            // Optionally: save the task for retry later
        });
        executor.initialize();
        return executor;
    }
    @Override
    public @NonNull AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, args) -> {
            System.err.println("🔴 Async exception in method: " + method.getName());
            throwable.printStackTrace();
        };
    }
}
