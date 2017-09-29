/**
 * 
 */
package com.qdynasty.hdService.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qdynasty.hdService.model.HistoryEvent;
import com.qdynasty.hdService.model.QueryPage;
import com.qdynasty.hdService.service.HistoryEventService;

import io.swagger.annotations.ApiOperation;

/**
 * @author qinfei
 *
 */
@RestController
@RequestMapping(value = "historyEvent")
public class HistoryEventController {

	@Resource(name = "historyEventService")
	private HistoryEventService historyEventService;
	
	@ApiOperation(value = "获取历史会议信息列表", notes = "获取历史会议列表,支持分页查询")
	@GetMapping(value = "/loadHistoryEvents")
	@ResponseBody
	public List<HistoryEvent> loadHistoryEvents(QueryPage queryPage)
	{
		return historyEventService.loadHistoryEventByPage(queryPage);
	}
}
