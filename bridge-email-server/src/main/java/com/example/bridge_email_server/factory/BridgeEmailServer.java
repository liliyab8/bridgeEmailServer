package com.example.bridge_email_server.factory;

import com.example.bridge_email_server.dto.EmployeeEmail;
import com.example.bridge_email_server.dto.impl.EmailMessageRequest;
import com.example.bridge_email_server.factory.interfaces.EmailFactory;
import org.springframework.stereotype.Service;

@Service
public class BridgeEmailServer {
    private final EmailFactoryProvider factoryProvider;
    public BridgeEmailServer(EmailFactoryProvider factoryProvider) {
        this.factoryProvider = factoryProvider;
    }
    public void sendMail(EmployeeEmail employeeEmail) {
        EmailFactory factory = factoryProvider.getFactory(employeeEmail.getMailPostfix());
        if (factory != null) {
            factory.createAndRunEmailSender(new EmailMessageRequest(employeeEmail.getName() + employeeEmail.getMailPostfix(),
                    employeeEmail.getTo(), employeeEmail.getBody()));
        } else {
            System.out.println("Unknown email type: " + employeeEmail.getMailPostfix());
        }
    }
}
