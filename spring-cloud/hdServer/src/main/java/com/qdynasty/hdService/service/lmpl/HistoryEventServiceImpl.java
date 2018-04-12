/**
 * 
 */
package com.qdynasty.hdService.service.lmpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.qdynasty.hdService.mapper.PartyMapper;
import com.qdynasty.hdService.model.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qdynasty.hdService.mapper.HistoryEventMapper;
import com.qdynasty.hdService.microservice.client.RtmServerClient;
import com.qdynasty.hdService.model.Conference;
import com.qdynasty.hdService.model.HistoryEvent;
import com.qdynasty.hdService.model.QueryPage;
import com.qdynasty.hdService.service.HistoryEventService;

/**
 * @author qinfei
 *
 */
@Service("historyEventService")
public class HistoryEventServiceImpl implements HistoryEventService {

	private Logger LOGGER = LoggerFactory.getLogger(HistoryEventServiceImpl.class);

	@Resource(name = "historyEventMapper")
	private HistoryEventMapper historyEventMapper;

	@Autowired
	private PartyMapper PartyMapper;

	@Autowired
	private RtmServerClient rtmServerClient;

	@Override
	public List<HistoryEvent> loadHistoryEventByPage(QueryPage queryPage, String billingCode) {
		LOGGER.info("[HistoryEventServiceImpl] loadHistoryEventByPage start.");

		Conference conference = rtmServerClient.loadConferenceByBillingCode(billingCode);

		if (conference == null || "-1".equals(conference.getId())) {
			LOGGER.info("[HistoryEventServiceImpl] loadHistoryEventByPage has error.");
			return new ArrayList<>();
		}

		String table = "monitor_party_event_" + conference.getBeginTime().substring(0, 10).replaceAll("-", "");

		LOGGER.info("HistoryEvent table=" + table);

		return historyEventMapper.queryConferenceByPage(table, conference.getId(), queryPage);
	}

	@Override
	public List<Party> loadConferencePartys(QueryPage queryPage, String billingCode) {
		LOGGER.info("loadConferencePartys start.");
		Conference conference = rtmServerClient.loadConferenceByBillingCode(billingCode);

		if (conference == null || "-1".equals(conference.getId())) {
			LOGGER.info("loadConferencePartys has error.");
			return new ArrayList<>();
		}

		List<Party> partyList = PartyMapper.queryPartyList(conference.getId(), queryPage);

		partyList.stream().forEach(Party::getPartyName);

		return partyList;
	}
}
