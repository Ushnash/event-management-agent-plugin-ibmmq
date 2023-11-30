package com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.solace.maas.ep.event.management.agent.plugin.ibmmq.processor.IbmMqQueueProcessor;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.enumeration.IbmMqRouteId;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.enumeration.IbmMqRouteType;
import com.solace.maas.ep.event.management.agent.plugin.processor.ScanTypeDescendentsProcessor;
import com.solace.maas.ep.event.management.agent.plugin.processor.logging.MDCProcessor;
import com.solace.maas.ep.event.management.agent.plugin.route.handler.base.DataPublisherRouteBuilder;
import com.solace.maas.ep.event.management.agent.plugin.route.manager.RouteManager;

@Component
public class IbmMqQueueDataPublisherRoute extends DataPublisherRouteBuilder {

    @Autowired
    public IbmMqQueueDataPublisherRoute(IbmMqQueueProcessor processor, RouteManager routeManager,
                                        MDCProcessor mdcProcessor, ScanTypeDescendentsProcessor scanTypeDescendentsProcessor) {
        super(processor, IbmMqRouteId.IBMMQ_QUEUE.label, IbmMqRouteType.IBMMQ_QUEUE.label,
                routeManager, mdcProcessor, scanTypeDescendentsProcessor);

    }
}
