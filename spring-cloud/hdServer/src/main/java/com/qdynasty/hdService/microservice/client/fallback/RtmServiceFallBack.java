/**
 * 
 */
package com.qdynasty.hdService.microservice.client.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.qdynasty.hdService.microservice.client.RtmServerClient;
import com.qdynasty.hdService.model.Conference;

/**
 * @author fei.qin
 *
 */
@Component
@RefreshScope
public class RtmServiceFallBack implements RtmServerClient {

	private Logger LOGGER = LoggerFactory.getLogger(RtmServiceFallBack.class);

	@Value("{$com.qdynasty.hdService.microservice.client.fallback.conference.billingcode}")
	private String fallbackBillingCode;

	@Value("{$com.qdynasty.hdService.microservice.client.fallback.conference.id}")
	private String fallbackId;

	@Value("{$com.qdynasty.hdService.microservice.client.fallback.conference.name}")
	private String name;

	@Value("{$com.qdynasty.hdService.microservice.client.fallback.conference.hostCode}")
	private String hostCode;

	@Value("{$com.qdynasty.hdService.microservice.client.fallback.conference.guestCode}")
	private String guestCode;

	@Override
	public Conference loadConferenceByBillingCode(String billingCode) {
		LOGGER.info("loadConferenceByBillingCode start.billingCode=" + billingCode);

		Conference conference = new Conference();
		conference.setId(fallbackId);
		conference.setBillingCode(fallbackBillingCode);
		conference.setName(name);
		conference.setHostCode(hostCode);
		conference.setGuestCode(guestCode);
		
		LOGGER.info("loadConferenceByBillingCode end.conference=" + conference.toString());

		return conference;
	}

}
