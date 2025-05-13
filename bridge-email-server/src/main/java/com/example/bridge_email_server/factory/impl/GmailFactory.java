package com.example.bridge_email_server.factory.impl;

import com.example.bridge_email_server.dto.impl.EmailMessageRequest;
import com.example.bridge_email_server.factory.interfaces.EmailFactory;
import com.example.bridge_email_server.services.interfaces.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class GmailFactory implements EmailFactory {
    private final EmailSender emailSender;
   @Autowired
   public GmailFactory(@Qualifier("GmailSender")
                          EmailSender emailSender) {
       this.emailSender = emailSender;
   }
    @Override
    public void createAndRunEmailSender(EmailMessageRequest request) {
        emailSender.send(request);
    }
    @Override
    public String getSupportedPostfix(){
       return "@gmail.com";
    }
}
