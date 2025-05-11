package com.example.bridge_email_server.services.impl;

import com.example.bridge_email_server.dto.abstr.MessageRequest;
import com.example.bridge_email_server.services.abstr.EmailSender;
import com.example.bridge_email_server.utils.EmailLogger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WallaSender implements EmailSender {
    @Qualifier("gmailSender")
    JavaMailSender wallaSender;
    @Override
    @Async("wallaTaskExecutor")
    public void send(MessageRequest request) {
        System.out.println("Start sending Walla");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(request.getFrom());
        simpleMailMessage.setTo(request.getTo());
        simpleMailMessage.setText(request.getBody());
       // wallaSender.send(simpleMailMessage);
        System.out.println("Sending walla message from " +
                request.getFrom() + " to " + request.getTo() + " : " + request.getBody());
        EmailLogger.log(request.getBody());
    }
}
