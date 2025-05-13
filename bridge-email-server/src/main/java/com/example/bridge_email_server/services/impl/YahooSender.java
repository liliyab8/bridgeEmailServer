package com.example.bridge_email_server.services.impl;

import com.example.bridge_email_server.dto.abstr.MessageRequest;
import com.example.bridge_email_server.services.interfaces.EmailSender;
import com.example.bridge_email_server.services.abstr.MessageSender;
import com.example.bridge_email_server.utils.EmailLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("YahooSender")
public class YahooSender extends MessageSender implements EmailSender {
    private static final Logger logger = LoggerFactory.getLogger(YahooSender.class);

    @Override
    @Async("yahooTaskExecutor")
    public void send(MessageRequest request) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(request.getFrom());
        simpleMailMessage.setTo(request.getTo());
        simpleMailMessage.setText(request.getBody());
       // yahooSender.send(simpleMailMessage);
        logger.info("Sending yahoo message from thread: " +
                        Thread.currentThread().getName() +
                        " | message: " +
                        request.getFrom() + " to " + request.getTo() + " : " + request.getBody()
                );
        EmailLogger.log(request.getBody());
    }
}
