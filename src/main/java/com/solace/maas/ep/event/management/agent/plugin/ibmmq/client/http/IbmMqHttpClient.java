package com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Uses OpenFeign to create the MQ REST API Admin Client.
 */
@FeignClient(name = "ibmmq-http-client")
public interface IbmMqHttpClient {

	/*Gets all queues on a given queue manager*/
	@GetMapping("/queue")
	IbmMqQueueResponse getQueues();

	/*Gets all subscriptions (topics) on a given queue manager*/
	@GetMapping("/subscription")
	IbmMqSubscriptionResponse getSubscriptions();
}
