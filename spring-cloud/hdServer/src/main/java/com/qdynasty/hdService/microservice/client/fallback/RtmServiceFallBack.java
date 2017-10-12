/**
 * 
 */
package com.qdynasty.hdService.microservice.client.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qdynasty.hdService.microservice.client.RtmServerClient;
import com.qdynasty.hdService.model.Conference;

/**
 * @author fei.qin
 *
 */
@Component
public class RtmServiceFallBack implements RtmServerClient {

	private Logger LOGGER = LoggerFactory.getLogger(RtmServiceFallBack.class);

	@Override
	public Conference loadConferenceByBillingCode(String billingCode) {
		LOGGER.info("loadConferenceByBillingCode start.billingCode=" + billingCode);
		
		Conference conference = new Conference();
		conference.setId("-1");
		
		return conference;
	}

}
