package com.example.bridge_email_server;

import com.example.bridge_email_server.config.BridgeEmailServerConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {BridgeEmailServerConfiguration.class})
class BridgeEmailServerApplicationTests {

	@Test
	void contextLoads() {
	}
}
