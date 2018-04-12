/**
 * 
 */
package com.qdynasty.hdService.controller;

import java.util.List;

import com.qdynasty.hdService.model.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qdynasty.hdService.model.HistoryEvent;
import com.qdynasty.hdService.model.QueryPage;
import com.qdynasty.hdService.service.HistoryEventService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author qinfei
 *
 */
@RestController
@RequestMapping(value = "/historyEvent")
public class HistoryEventController {

	@Autowired
	private HistoryEventService historyEventService;

	@ApiOperation(value = "获取历史会议信息列表", notes = "获取历史会议列表,支持分页查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "queryPage", value = "分页查询实体", paramType="query", required = true, dataType = "QueryPage"),
			@ApiImplicitParam(name = "billingCode", value = "会议BillingCode", paramType="query", required = true, dataType = "String") })
	@GetMapping(value = "/loadHistoryEvents")
	@ResponseBody
	public List<HistoryEvent> loadHistoryEvents(QueryPage queryPage, String billingCode) {
		return historyEventService.loadHistoryEventByPage(queryPage, billingCode);
	}

    @ApiOperation(value = "获取会议参会人列表", notes = "获取会议参会人列表,支持分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryPage", value = "分页查询实体", paramType="query", required = true, dataType = "QueryPage"),
            @ApiImplicitParam(name = "billingCode", value = "会议BillingCode", paramType="query", required = true, dataType = "String") })
    @GetMapping(value = "/loadPartyList")
    @ResponseBody
    public List<Party> loadPartyList(QueryPage queryPage, String billingCode) {
        return historyEventService.loadConferencePartys(queryPage, billingCode);
    }

}
