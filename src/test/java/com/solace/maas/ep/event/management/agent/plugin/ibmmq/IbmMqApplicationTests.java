package com.solace.maas.ep.event.management.agent.plugin.ibmmq;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http.IbmMqHttpClient;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http.IbmMqQueueResponse;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.manager.client.IbmMqClientManagerImpl;
import com.solace.maas.ep.event.management.agent.plugin.messagingService.event.AuthenticationDetailsEvent;
import com.solace.maas.ep.event.management.agent.plugin.messagingService.event.ConnectionDetailsEvent;
import com.solace.maas.ep.event.management.agent.plugin.messagingService.event.CredentialDetailsEvent;
import com.solace.maas.ep.event.management.agent.plugin.messagingService.event.EventProperty;
import com.solace.maas.ep.event.management.agent.plugin.util.MessagingServiceConfigurationUtil;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = IbmMqTestConfig.class)
class IbmMqApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testPlugin() {
		IbmMqClientManagerImpl client = new IbmMqClientManagerImpl();
		ConnectionDetailsEvent connect = ConnectionDetailsEvent.builder()
				.url("https://web-qm1-5bc5.qm.us-south.mq.appdomain.cloud")
				.messagingServiceId("1")
				.name("name")
				.authenticationDetails(List.of(AuthenticationDetailsEvent.builder()
						.credentials(List.of(CredentialDetailsEvent.builder()
								.properties(List.of(
										EventProperty.builder()
												.name("username")
												.value("ush")
												.build(),
										EventProperty.builder()
												.name("password")
												.value("E5J8yGHjPTErikzOVZ0FiloP47FooNKQSTcTx5jQE-oM")
												.build()))
								.build()))
						.build()))
				.properties(List.of(
						EventProperty.builder()
								.name("QueueManager")
								.value("QM1")
								.build()))
				.build();

		IbmMqHttpClient c = client.getClient(connect);
		String qm = MessagingServiceConfigurationUtil.getProperty(connect.getProperties(), "QueueManager");

		try {
			IbmMqQueueResponse queues = c.getQueues(qm);
			System.out.println();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
