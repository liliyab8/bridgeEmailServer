package com.example.bridge_email_server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "email")
@Data
public class EmailProperties {
    private List<String> postfixes;
    public List<String> getPostfixes() {
        return postfixes;
    }
    public void setPostfixes(List<String> postfixes) {
        this.postfixes = postfixes;
    }
}
