package com.solace.maas.ep.event.management.agent.plugin.ibmmq.processor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.solace.maas.ep.event.management.agent.plugin.constants.RouteConstants;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http.IbmMqHttpClient;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http.IbmMqQueueResponse;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.processor.event.IbmMqQueueEvent;
import com.solace.maas.ep.event.management.agent.plugin.processor.base.ResultProcessorImpl;
import com.solace.maas.ep.event.management.agent.plugin.service.MessagingServiceDelegateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IbmMqQueueProcessor extends ResultProcessorImpl<List<IbmMqQueueEvent>, Void> {
	private final MessagingServiceDelegateService messagingServiceDelegateService;

	public IbmMqQueueProcessor(MessagingServiceDelegateService messagingServiceDelegateService) {
		super();
		this.messagingServiceDelegateService = messagingServiceDelegateService;
		log.debug("### In Queue Processor ###");
	}

	@Override
	public List<IbmMqQueueEvent> handleEvent(Map<String, Object> properties, Void body) throws Exception {
		String messagingServiceId = (String) properties.get(RouteConstants.MESSAGING_SERVICE_ID);

		IbmMqHttpClient client = messagingServiceDelegateService.getMessagingServiceClient(messagingServiceId);

		log.info("### Invoking Queue endpoint for messaging service with ID {}", messagingServiceId);
		IbmMqQueueResponse queueList = client.getQueues(properties.get("QueueManager").toString());

		return queueList.getQueue();
	}

}