package com.example.bridge_email_server.services.interfaces;

import com.example.bridge_email_server.dto.abstr.MessageRequest;

public interface EmailSender{
    public void send(MessageRequest request);
}

