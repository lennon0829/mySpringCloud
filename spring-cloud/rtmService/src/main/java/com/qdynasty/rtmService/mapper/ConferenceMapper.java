/**
 * 
 */
package com.qdynasty.rtmService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.qdynasty.rtmService.model.Conference;
import com.qdynasty.rtmService.model.QueryPage;

/**
 * @author fei.qin
 *
 */
@Mapper
@Repository("conferenceMapper")
public interface ConferenceMapper {

	@Select("select billingcode, name, hostCode, guestCode, bridgeName, beginTime, endTime from confs limit #{queryPage.start}, #{queryPage.limit}")
	@Results({ @Result(property = "billingCode", column = "billingcode"),
			@Result(property = "name", column = "billingcode"), 
			@Result(property = "hostCode", column = "hostCode"),
			@Result(property = "guestCode", column = "guestCode"),
			@Result(property = "bridgeName", column = "bridgeName"),
			@Result(property = "beginTime", column = "beginTime"), 
			@Result(property = "endTime", column = "endTime") })
	List<Conference> queryConferenceByPage(@Param("queryPage") QueryPage queryPage);
}
