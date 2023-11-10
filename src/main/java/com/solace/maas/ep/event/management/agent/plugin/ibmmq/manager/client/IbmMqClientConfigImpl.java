/**
 * 
 */
package com.solace.maas.ep.event.management.agent.plugin.ibmmq.manager.client;

import com.solace.maas.ep.event.management.agent.plugin.manager.client.MessagingServiceClientConfig;

/**
 * 
 */
public class IbmMqClientConfigImpl extends MessagingServiceClientConfig {

	private static final String SERVICE_NAME = "IBMMQ";

	protected IbmMqClientConfigImpl() {
		super(SERVICE_NAME, new IbmMqClientManagerImpl());
	}

}
