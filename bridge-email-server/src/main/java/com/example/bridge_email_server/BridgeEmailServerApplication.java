package com.example.bridge_email_server;

import com.example.bridge_email_server.dto.EmployeeEmail;
import com.example.bridge_email_server.factory.BridgeEmailServer;
import com.example.bridge_email_server.factory.interfaces.EmailFactory;
import com.example.bridge_email_server.factory.EmailFactoryProvider;
import com.example.bridge_email_server.factory.impl.GmailFactory;
import com.example.bridge_email_server.factory.impl.WallaFactory;
import com.example.bridge_email_server.factory.impl.YahooFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = { "com.*"})
@EnableAsync
//@EnableScheduling
public class BridgeEmailServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeEmailServerApplication.class, args);

		Map<String, EmailFactory> factoryMap = new HashMap<>();
		factoryMap.put("@gmail.com", new GmailFactory());
		factoryMap.put("@walla.com", new WallaFactory());
		factoryMap.put("@yahoo.com", new YahooFactory());

		BridgeEmailServer bridgeEmailServer = new BridgeEmailServer(new EmailFactoryProvider(factoryMap));

		//EmailMessageRequest mr = new EmailMessageRequest("111", "222", "333");
		EmployeeEmail ee1 = new EmployeeEmail("qqq", "@gmail.com", "wwweeraw5tsgdth", "eee$gmail.com");
		/*EmployeeEmail ee2 = new EmployeeEmail("ggg", "@gmail.com", "www", "eee$gmail.com");
		EmployeeEmail ee3 = new EmployeeEmail("fff", "@gmail.com", "www", "eee$gmail.com");
		EmployeeEmail ee4 = new EmployeeEmail("hhh", "@gmail.com", "www", "eee$gmail.com");
		EmployeeEmail ee5 = new EmployeeEmail("mmm", "@gmail.com", "www", "eee$gmail.com");
		EmployeeEmail ee6 = new EmployeeEmail("kkk", "@gmail.com", "www", "eee$gmail.com");
		EmployeeEmail ee7 = new EmployeeEmail("lll", "@gmail.com", "www", "eee$gmail.com");
		EmployeeEmail ee8 = new EmployeeEmail("sss", "@gmail.com", "www", "eee$gmail.com");
		EmployeeEmail ee9 = new EmployeeEmail("lll", "@gmail.com", "www", "eee$gmail.com");
		EmployeeEmail ee10 = new EmployeeEmail("sss", "@gmail.com", "www", "eee$gmail.com");*/

		EmployeeEmail ee11 = new EmployeeEmail("qqq", "@walla.com", "wwwstgdaw4w4rhyrru6", "eee$walla.com");
		/*EmployeeEmail ee12 = new EmployeeEmail("ggg", "@walla.com", "www", "eee$gmail.com");
		EmployeeEmail ee13 = new EmployeeEmail("fff", "@walla.com", "www", "eee$gmail.com");
		EmployeeEmail ee14 = new EmployeeEmail("hhh", "@walla.com", "www", "eee$gmail.com");
		EmployeeEmail ee15 = new EmployeeEmail("mmm", "@walla.com", "www", "eee$gmail.com");
		EmployeeEmail ee16 = new EmployeeEmail("kkk", "@walla.com", "www", "eee$gmail.com");
		EmployeeEmail ee17 = new EmployeeEmail("lll", "@walla.com", "www", "eee$gmail.com");
		EmployeeEmail ee18 = new EmployeeEmail("sss", "@walla.com", "www", "eee$gmail.com");
		EmployeeEmail ee19 = new EmployeeEmail("lll", "@walla.com", "www", "eee$gmail.com");
		EmployeeEmail ee20 = new EmployeeEmail("sss", "@walla.com", "www", "eee$gmail.com");*/

		EmployeeEmail ee21 = new EmployeeEmail("qqq", "@yahoo.com", "www4sdfzgs5e6dh76hrfn", "eee$gmail.com");
		/*EmployeeEmail ee22 = new EmployeeEmail("ggg", "@yahoo.com", "www", "eee$gmail.com");
		EmployeeEmail ee23 = new EmployeeEmail("fff", "@yahoo.com", "www", "eee$gmail.com");
		EmployeeEmail ee24 = new EmployeeEmail("hhh", "@yahoo.com", "www", "eee$gmail.com");
		EmployeeEmail ee25 = new EmployeeEmail("mmm", "@yahoo.com", "www", "eee$gmail.com");
		EmployeeEmail ee26 = new EmployeeEmail("kkk", "@yahoo.com", "www", "eee$gmail.com");
		EmployeeEmail ee27 = new EmployeeEmail("lll", "@yahoo.com", "www", "eee$gmail.com");
		EmployeeEmail ee28 = new EmployeeEmail("sss", "@yahoo.com", "www", "eee$gmail.com");
		EmployeeEmail ee29 = new EmployeeEmail("lll", "@yahoo.com", "www", "eee$gmail.com");
		EmployeeEmail ee30 = new EmployeeEmail("sss", "@yahoo.com", "www", "eee$gmail.com");*/

		System.out.println("Started Main Thread");

		bridgeEmailServer.sendMail(ee1);
		/*bridgeEmailServer.sendMail(ee2);
		bridgeEmailServer.sendMail(ee3);
		bridgeEmailServer.sendMail(ee4);
		bridgeEmailServer.sendMail(ee5);
		bridgeEmailServer.sendMail(ee6);
		bridgeEmailServer.sendMail(ee7);
		bridgeEmailServer.sendMail(ee8);
		bridgeEmailServer.sendMail(ee9);
		bridgeEmailServer.sendMail(ee10);*/

		bridgeEmailServer.sendMail(ee11);
		/*bridgeEmailServer.sendMail(ee12);
		bridgeEmailServer.sendMail(ee13);
		bridgeEmailServer.sendMail(ee14);
		bridgeEmailServer.sendMail(ee15);
		bridgeEmailServer.sendMail(ee16);
		bridgeEmailServer.sendMail(ee17);
		bridgeEmailServer.sendMail(ee18);
		bridgeEmailServer.sendMail(ee19);
		bridgeEmailServer.sendMail(ee20);*/


		bridgeEmailServer.sendMail(ee21);
		/*bridgeEmailServer.sendMail(ee22);
		bridgeEmailServer.sendMail(ee23);
		bridgeEmailServer.sendMail(ee24);
		bridgeEmailServer.sendMail(ee25);
		bridgeEmailServer.sendMail(ee26);
		bridgeEmailServer.sendMail(ee27);
		bridgeEmailServer.sendMail(ee28);
		bridgeEmailServer.sendMail(ee29);
		bridgeEmailServer.sendMail(ee30);
*/
		System.out.println("Ended Main Thread");
	}
}
