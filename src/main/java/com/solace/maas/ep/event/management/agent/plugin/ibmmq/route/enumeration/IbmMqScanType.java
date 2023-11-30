package com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.enumeration;

public enum IbmMqScanType {

    IBMMQ_ALL("IbmMqAll"),
    IBMMQ_QUEUE("IbmMqQueue"),
    IBMMQ_SUBSCRIPTION("IbmMqSubscription");

    public final String label;

    IbmMqScanType(String label) {
        this.label = label;
    }
}
