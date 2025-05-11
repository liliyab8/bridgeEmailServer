package com.example.bridge_email_server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration

public class BridgeEmailServerConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.mail.gmail")
    public JavaMailSender getGmailSender() {
        return new JavaMailSenderImpl();
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.mail.walla")
    public JavaMailSender getWallaSender() {
        return new JavaMailSenderImpl();
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.mail.yahoo")
    public JavaMailSender getYahooSender() {
        return new JavaMailSenderImpl();
    }
}
