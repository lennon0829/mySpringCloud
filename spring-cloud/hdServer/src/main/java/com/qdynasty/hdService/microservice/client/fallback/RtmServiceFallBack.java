/**
 * 
 */
package com.qdynasty.hdService.microservice.client.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qdynasty.hdService.microservice.client.RtmServerClient;

/**
 * @author fei.qin
 *
 */
@Component
public class RtmServiceFallBack implements RtmServerClient {

	private Logger LOGGER = LoggerFactory.getLogger(RtmServiceFallBack.class);

	@Override
	public String loadConferenceByBillingCode(String billingCode) {
		LOGGER.info("loadConferenceByBillingCode start.billingCode=" + billingCode);
		return null;
	}

}
