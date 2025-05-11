package com.example.bridge_email_server.dto.impl;

import com.example.bridge_email_server.dto.abstr.MessageRequest;
import lombok.Data;
import lombok.Getter;

@Data
public class EmailMessageRequest extends MessageRequest {
    public EmailMessageRequest(String from, String to, String body) {
        super(from, to, body);
    }

}
