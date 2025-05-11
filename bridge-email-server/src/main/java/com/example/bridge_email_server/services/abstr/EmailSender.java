package com.example.bridge_email_server.services.abstr;

import com.example.bridge_email_server.dto.abstr.MessageRequest;
import com.example.bridge_email_server.services.interfaces.MessageSender;

public interface EmailSender extends MessageSender {
    public void send(MessageRequest request);

}
