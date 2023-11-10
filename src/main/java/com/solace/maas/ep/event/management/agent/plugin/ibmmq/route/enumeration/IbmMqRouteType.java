package com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.enumeration;

public enum IbmMqRouteType {
	IBMMQ_QUEUE("queue"),
	IBMMQ_SUBSCRIPTION("subscription");

	public final String label;

	IbmMqRouteType(String label) {
		this.label = label;
	}
}
