/**
 * 
 */
package com.qdynasty.hdService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.qdynasty.hdService.model.HistoryEvent;
import com.qdynasty.hdService.model.QueryPage;

/**
 * @author qinfei
 *
 */
@Mapper
@Repository("historyEventMapper")
public interface HistoryEventMapper {

	@Select("select conference_id, event_time, phone, bridge_partyname, connectstate from ${table} where conference_id = #{conferenceId} limit #{queryPage.start}, #{queryPage.limit}")
	@Results({ @Result(property = "conferenceId", column = "conference_id"),
			@Result(property = "eventTime", column = "event_time"), 
			@Result(property = "phone", column = "phone"),
			@Result(property = "partyName", column = "bridge_partyname"),
			@Result(property = "connectstate", column = "connectstate") })
	List<HistoryEvent> queryConferenceByPage(@Param("table") String table, @Param("conferenceId") String conferenceId, @Param("queryPage") QueryPage queryPage);
}
