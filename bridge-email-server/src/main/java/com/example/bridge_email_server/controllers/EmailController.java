package com.example.bridge_email_server.controllers;

import com.example.bridge_email_server.dto.EmployeeEmail;
import com.example.bridge_email_server.factory.BridgeEmailServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-email")

public class EmailController {
    private final BridgeEmailServer bridgeEmailServer;

    @Autowired
    public EmailController(BridgeEmailServer bridgeEmailServer) {
        this.bridgeEmailServer = bridgeEmailServer;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmployeeEmail request) {
        try {
            bridgeEmailServer.sendMail(request);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to send email: " + e.getMessage());
        }
    }
}
