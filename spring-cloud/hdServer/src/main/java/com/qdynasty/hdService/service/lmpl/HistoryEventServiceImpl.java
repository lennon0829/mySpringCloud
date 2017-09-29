/**
 * 
 */
package com.qdynasty.hdService.service.lmpl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qdynasty.hdService.mapper.HistoryEventMapper;
import com.qdynasty.hdService.model.HistoryEvent;
import com.qdynasty.hdService.model.QueryPage;
import com.qdynasty.hdService.service.HistoryEventService;

/**
 * @author qinfei
 *
 */
public class HistoryEventServiceImpl implements HistoryEventService {
	
	private Logger LOGGER = LoggerFactory.getLogger(HistoryEventServiceImpl.class);
	
	@Resource(name = "historyEventMapper")
	private HistoryEventMapper historyEventMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qdynasty.hdService.service.HistoryEventService#loadHistoryEventByPage(com
	 * .qdynasty.hdService.model.QueryPage)
	 */
	@Override
	public List<HistoryEvent> loadHistoryEventByPage(QueryPage queryPage) {
		LOGGER.info("[HistoryEventServiceImpl] loadHistoryEventByPage start.");
		return historyEventMapper.queryConferenceByPage(queryPage);
	}

}
