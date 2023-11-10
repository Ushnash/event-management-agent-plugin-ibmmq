package com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.enumeration.IbmMqRouteId;
import com.solace.maas.ep.event.management.agent.plugin.ibmmq.route.enumeration.IbmMqScanType;
import com.solace.maas.ep.event.management.agent.plugin.jacoco.ExcludeFromJacocoGeneratedReport;
import com.solace.maas.ep.event.management.agent.plugin.route.RouteBundle;
import com.solace.maas.ep.event.management.agent.plugin.route.delegate.base.MessagingServiceRouteDelegateImpl;

@ExcludeFromJacocoGeneratedReport
@SuppressWarnings("CPD-START")
@Component
public class IbmMqRouteDelegateImpl extends MessagingServiceRouteDelegateImpl {

	public IbmMqRouteDelegateImpl() {
		super("IBMMQ");
		System.out.println("### PLUGIN `IBMMQ` HAS LOADED ###");
	}

	public List<RouteBundle> generateRouteList(List<RouteBundle> destinations, List<RouteBundle> recipients,
			String scanType, String messagingServiceId) {
		List<RouteBundle> result = new ArrayList<>();

		switch (IbmMqScanType.valueOf(scanType)) {
		case IBMMQ_ALL:
			result.add(queueRouteBundle(destinations, recipients, messagingServiceId,
					IbmMqScanType.IBMMQ_QUEUE.name()));

			result.add(subscriptionRouteBundle(destinations, recipients, messagingServiceId,
					IbmMqScanType.IBMMQ_SUBSCRIPTION.name()));
			break;
		case IBMMQ_QUEUE:
			result.add(queueRouteBundle(destinations, recipients, messagingServiceId,
					IbmMqScanType.IBMMQ_QUEUE.name()));
			break;
		case IBMMQ_SUBSCRIPTION:
			result.add(subscriptionRouteBundle(destinations, recipients, messagingServiceId,
					IbmMqScanType.IBMMQ_SUBSCRIPTION.name()));
			break;
		}

		return result;
	}

	private RouteBundle queueRouteBundle(List<RouteBundle> destinations, List<RouteBundle> recipients,
			String messagingServiceId, String scanType) {
		return createRouteBundle(destinations, recipients, scanType, messagingServiceId,
				IbmMqRouteId.IBMMQ_QUEUE.label, true);
	}

	private RouteBundle subscriptionRouteBundle(List<RouteBundle> destinations, List<RouteBundle> recipients,
			String messagingServiceId, String scanType) {
		return createRouteBundle(destinations, recipients, scanType, messagingServiceId,
				IbmMqRouteId.IBMMQ_SUBSCRIPTION.label, true);
	}
}
