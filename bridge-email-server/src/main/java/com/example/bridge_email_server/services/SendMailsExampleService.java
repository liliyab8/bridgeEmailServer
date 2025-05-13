package com.example.bridge_email_server.services;

import com.example.bridge_email_server.dto.EmployeeEmail;
import com.example.bridge_email_server.factory.BridgeEmailServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SendMailsExampleService implements CommandLineRunner {
	private final BridgeEmailServer bridgeEmailServer;

	@Autowired
	public SendMailsExampleService(BridgeEmailServer bridgeEmailServer) {
		this.bridgeEmailServer = bridgeEmailServer;
	}

	@Override
	public void run(String... args) {
		EmployeeEmail email1 = new EmployeeEmail("John", "@gmail.com", "Test Mail", "receiver@example.com");
		EmployeeEmail email2 = new EmployeeEmail("Katerina", "@walla.co.il", "Test Mail", "receiver@example.com");
		EmployeeEmail email3 = new EmployeeEmail("Leon", "@yahoo.com", "Test Mail", "receiver@example.com");

		for (int i = 0; i < 10; i++) {
			bridgeEmailServer.sendMail(email1);
		}
		for (int i = 0; i < 10; i++) {
			bridgeEmailServer.sendMail(email2);
		}
		for (int i = 0; i < 10; i++) {
			bridgeEmailServer.sendMail(email3);
		}
		for (int i = 0; i < 10; i++) {
			bridgeEmailServer.sendMail(email1);
			bridgeEmailServer.sendMail(email2);
			bridgeEmailServer.sendMail(email3);
		}
	}
}
