package com.example.bridge_email_server.factory;

import com.example.bridge_email_server.config.EmailProperties;
import com.example.bridge_email_server.factory.interfaces.EmailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmailFactoryProvider {
    private final Map<String, EmailFactory> factoryMap;
    @Autowired
    public EmailFactoryProvider(List<EmailFactory> factories, EmailProperties emailProperties) {
        this.factoryMap = new HashMap<>();
        for (EmailFactory factory : factories) {
            String postfix = factory.getSupportedPostfix();
            if (emailProperties.getPostfixes().contains(postfix)) {
                factoryMap.put(postfix, factory);
            }
        }
    }
    public EmailFactory getFactory(String type) {
        return factoryMap.get(type);
    }
}
