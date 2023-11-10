package com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//TODO:Externalize Version

@FeignClient(name = "ibmmq-http-client")
public interface IbmMqHttpClient {

	@GetMapping("/ibmmq/rest/v1/admin/qmgr")
	String getQueueManagers();

	@GetMapping("/ibmmq/rest/v1/admin/qmgr/{qmgrName}/queue")
	IbmMqQueueResponse getQueues(@PathVariable("qmgrName") String qmgrName);
	
	@GetMapping("/ibmmq/rest/v1/admin/qmgr/{qmgrName}/subscription")
	IbmMqSubscriptionResponse getSubscriptions(@PathVariable("qmgrName") String qmgrName);
}
