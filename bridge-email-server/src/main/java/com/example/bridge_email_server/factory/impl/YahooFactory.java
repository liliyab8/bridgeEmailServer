package com.example.bridge_email_server.factory.impl;

import com.example.bridge_email_server.dto.impl.EmailMessageRequest;
import com.example.bridge_email_server.factory.interfaces.EmailFactory;
import com.example.bridge_email_server.services.interfaces.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class YahooFactory implements EmailFactory {
    private final EmailSender emailSender;
    @Autowired
    public YahooFactory(@Qualifier("YahooSender")EmailSender emailSender) {
        this.emailSender = emailSender;
    }
    @Override
    public void createAndRunEmailSender(EmailMessageRequest request) {
        emailSender.send(request);
    }
    @Override
    public String getSupportedPostfix(){
        return "@yahoo.com";
    }
}
