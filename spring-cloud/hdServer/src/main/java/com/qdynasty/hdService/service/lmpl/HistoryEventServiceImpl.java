/**
 * 
 */
package com.qdynasty.hdService.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.qdynasty.hdService.mapper.HistoryEventMapper;
import com.qdynasty.hdService.microservice.client.RtmServerClient;
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
	private RtmServerClient rtmServerClient;

	@Override
	public List<HistoryEvent> loadHistoryEventByPage(QueryPage queryPage, String billingCode) {
		LOGGER.info("[HistoryEventServiceImpl] loadHistoryEventByPage start.");

		String queryResult = rtmServerClient.loadConferenceByBillingCode(billingCode);

		if (StringUtils.isEmpty(queryResult)) {
			return null;
		}

		String beginTime = (String) JSON.parseObject(queryResult).get("beginTime");
		String conferenceId = (String) JSON.parseObject(queryResult).get("id");

		String table = "monitor_party_event_" + beginTime.substring(0, 10).replaceAll("-", "");

		LOGGER.info("HistoryEvent table=" + table);

		return historyEventMapper.queryConferenceByPage(table, conferenceId, queryPage);
	}

}
