package com.xuzw.demo.dao.mapper.ext;

import com.xuzw.demo.dao.entity.BidCongerenceIdea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BidCongerenceTopicExtMapper {

    /**
     * 传入会议主键id 统计决议结果
     * @param conferenceId
     * @return
     */
    List<BidCongerenceIdea> statisticalAnalysis(@Param("conferenceId") Long conferenceId);

}
