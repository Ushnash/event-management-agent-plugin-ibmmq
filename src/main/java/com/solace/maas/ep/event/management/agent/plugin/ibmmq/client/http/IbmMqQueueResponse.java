package com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http;

import java.util.List;

import com.solace.maas.ep.event.management.agent.plugin.ibmmq.processor.event.IbmMqQueueEvent;

import lombok.Data;

@Data
public class IbmMqQueueResponse {

	List<IbmMqQueueEvent> queue;
}
