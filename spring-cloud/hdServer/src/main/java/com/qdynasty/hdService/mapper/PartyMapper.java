package com.qdynasty.hdService.mapper;

import com.qdynasty.hdService.model.Party;
import com.qdynasty.hdService.model.QueryPage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PartyMapper {

    /**
     * 根据会议ID查询会议参会人列表
     * @param confid
     * @param queryPage
     * @return
     */
    @Select("select partyName, partyId, phone from parties where confid = #{confid} limit #{queryPage.start}, #{queryPage.limit}")
    List<Party> queryPartyList(@Param("confid") String confid, @Param("queryPage") QueryPage queryPage);
}
