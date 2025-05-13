package com.example.bridge_email_server.services.interfaces;

import com.example.bridge_email_server.dto.abstr.MessageRequest;

interface EmailSender /*implements MessageSender*/ {
    public void send(MessageRequest request);
}

