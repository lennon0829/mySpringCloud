/**
 * 
 */
package com.qdynasty.rtmService.service;

import java.util.List;

import com.qdynasty.rtmService.model.Conference;
import com.qdynasty.rtmService.model.QueryPage;

/**
 * @author fei.qin
 *
 */
public interface ConferenceService {

	List<Conference> loadConferenceByPage(QueryPage queryPage);
	
	Conference loadConferenceByBillingCode(String billingCode);
}
