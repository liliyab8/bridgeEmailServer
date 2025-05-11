package com.example.bridge_email_server.dto.abstr;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class MessageRequest {
    private String from;
    private String to;
    private String body;
    protected MessageRequest(String from, String to, String body){
        this.from = from;
        this.to = to;
        this.body = body;
    }
}
