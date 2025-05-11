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
public class YahooSender implements EmailSender {
    @Qualifier("gmailSender")
    JavaMailSender yahooSender;
    @Override
    @Async("yahooTaskExecutor")
    public void send(MessageRequest request) {
        System.out.println("Start sending Yahoo");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(request.getFrom());
        simpleMailMessage.setTo(request.getTo());
        simpleMailMessage.setText(request.getBody());
       // yahooSender.send(simpleMailMessage);
        System.out.println("Sending yahoo gmail message from " +
                request.getFrom() + " to " + request.getTo() + " : " + request.getBody());
        EmailLogger.log(request.getBody());
    }
}
