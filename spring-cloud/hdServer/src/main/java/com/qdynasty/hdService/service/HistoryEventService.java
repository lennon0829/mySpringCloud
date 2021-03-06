/**
 * 
 */
package com.qdynasty.hdService.service;

import java.util.List;

import com.qdynasty.hdService.model.HistoryEvent;
import com.qdynasty.hdService.model.Party;
import com.qdynasty.hdService.model.QueryPage;

/**
 * @author qinfei
 *
 */
public interface HistoryEventService {

	List<HistoryEvent> loadHistoryEventByPage(QueryPage queryPage, String billingCode);

	List<Party> loadConferencePartys(QueryPage queryPage, String billingCode);
}
