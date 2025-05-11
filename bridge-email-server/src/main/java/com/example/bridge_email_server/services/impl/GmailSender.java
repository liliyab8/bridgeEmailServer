package com.example.bridge_email_server.services.impl;

import com.example.bridge_email_server.dto.abstr.MessageRequest;
import com.example.bridge_email_server.services.abstr.EmailSender;
import com.example.bridge_email_server.utils.EmailLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class GmailSender implements EmailSender {
    @Autowired
    @Qualifier("getGmailSender")
    JavaMailSender gmailSender;
    @Override
    @Async("gmailTaskExecutor")
    public void send(MessageRequest request) {
        System.out.println("Start sending Gmail");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(request.getFrom());
        simpleMailMessage.setTo(request.getTo());
        simpleMailMessage.setText(request.getBody());
        //gmailSender.send(simpleMailMessage);
        System.out.println("Sending gmail message from " +
                request.getFrom() + " to " + request.getTo() + " : " + request.getBody());
        EmailLogger.log(request.getBody());
    }
}
