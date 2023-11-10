package com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.enumeration;

public enum IbmMqRouteId {
	IBMMQ_QUEUE("ibmMqQueue"),
	IBMMQ_SUBSCRIPTION("ibmMqSubscription");

	public final String label;

	IbmMqRouteId(String label) {
		this.label = label;
	}
}
