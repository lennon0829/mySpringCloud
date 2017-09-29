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

	@Select("select billingcode from confs limit #{queryPage.start}, #{queryPage.limit}")
	@Results({ @Result(property = "billingCode", column = "billingcode")})
	List<HistoryEvent> queryConferenceByPage(@Param("queryPage") QueryPage queryPage);
}
