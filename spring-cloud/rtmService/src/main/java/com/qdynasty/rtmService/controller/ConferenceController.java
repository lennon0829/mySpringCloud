/**
 * 
 */
package com.qdynasty.rtmService.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qdynasty.rtmService.model.Conference;
import com.qdynasty.rtmService.model.QueryPage;
import com.qdynasty.rtmService.service.ConferenceService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author fei.qin
 *
 */
@RestController
@RequestMapping(value = "/conference")
public class ConferenceController {

	@Resource(name = "conferenceService")
	private ConferenceService conferenceService;

	@ApiOperation(value = "获取会议列表", notes = "获取会议列表,支持分页查询")
	@ApiImplicitParam(name = "queryPage", value = "分页查询实体", paramType = "query", required = true, dataType = "QueryPage")
	@GetMapping(value = "/loadConferences")
	@ResponseBody
	public List<Conference> loadConferences(QueryPage queryPage) {

		if (queryPage.getLimit() == 0) {
			return null;
		}

		return conferenceService.loadConferenceByPage(queryPage);
	}

	@ApiOperation(value = "根据BillingCode, 获取会议列表", notes = "根据BillingCode, 获取会议列表")
	@ApiImplicitParam(name = "billingCode", value = "分页查询实体", paramType = "query", required = true, dataType = "String")
	@GetMapping(value = "/loadConferenceByBillingCode")
	@ResponseBody
	public Conference loadConferenceByBillingCode(String billingCode) {

		return conferenceService.loadConferenceByBillingCode(billingCode);
	}
}
