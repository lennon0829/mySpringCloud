/**
 * 
 */
package com.qdynasty.rtmService.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qdynasty.rtmService.mapper.ConferenceMapper;
import com.qdynasty.rtmService.model.Conference;
import com.qdynasty.rtmService.model.QueryPage;
import com.qdynasty.rtmService.service.ConferenceService;

/**
 * @author fei.qin
 *
 */
@Service("conferenceService")
public class ConferenceServiceImpl implements ConferenceService {

    /**
     * 日志记录
     */
    private static Logger LOGGER = LoggerFactory.getLogger(ConferenceServiceImpl.class);
    
	@Resource(name = "conferenceMapper")
	private ConferenceMapper conferenceMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qdynasty.rtmService.service.ConferenceService#loadConferenceByPage(com.
	 * qdynasty.rtmService.model.QueryPage)
	 */
	@Override
	public List<Conference> loadConferenceByPage(QueryPage queryPage) {
		LOGGER.info("[ConferenceServiceImpl] loadConferenceByPage start.");
		return conferenceMapper.queryConferenceByPage(queryPage);
	}

}
