package com.example.bridge_email_server.factory;

import com.example.bridge_email_server.factory.interfaces.EmailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmailFactoryProvider {
    private final Map<String, EmailFactory> factoryMap;
    @Autowired
    public EmailFactoryProvider(Map<String, EmailFactory> factoryMap) {
        this.factoryMap = factoryMap;
    }
    public EmailFactory getFactory(String type) {
        return factoryMap.get(type);
    }
}
