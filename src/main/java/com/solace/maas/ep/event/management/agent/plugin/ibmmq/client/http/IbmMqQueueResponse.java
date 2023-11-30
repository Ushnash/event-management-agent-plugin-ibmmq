package com.solace.maas.ep.event.management.agent.plugin.ibmmq.client.http;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.processor.event.IbmMqQueueEvent;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class IbmMqQueueResponse {

	private List<IbmMqQueueEvent> queue;
}
