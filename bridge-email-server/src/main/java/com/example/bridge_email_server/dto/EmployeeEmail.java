package com.example.bridge_email_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeEmail {
    private String name;
    private String mailPostfix;
    private String body;
    private String to;
}
