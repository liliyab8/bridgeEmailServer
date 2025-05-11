package com.example.bridge_email_server.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="email")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email_postfix")
    private String emailPostfix;
    @Column(name = "email_password")
    private String emailPassword;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

}
