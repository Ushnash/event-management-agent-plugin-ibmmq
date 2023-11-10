package com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http;

import java.util.List;

import com.solace.maas.ep.event.management.agent.plugin.ibmmq.processor.event.IbmMqQueueEvent;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.processor.event.IbmMqSubscriptionEvent;

import lombok.Data;

@Data
public class IbmMqSubscriptionResponse {

	List<IbmMqSubscriptionEvent> subscription;
}
