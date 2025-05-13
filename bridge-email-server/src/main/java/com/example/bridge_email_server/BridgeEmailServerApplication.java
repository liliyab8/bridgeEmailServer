package com.example.bridge_email_server;

import com.example.bridge_email_server.config.EmailProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = { "com.*"})
@EnableConfigurationProperties(EmailProperties.class)
@EnableAsync
public class BridgeEmailServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeEmailServerApplication.class, args);
	}
}
