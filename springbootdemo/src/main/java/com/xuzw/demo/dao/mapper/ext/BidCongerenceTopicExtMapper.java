package com.xuzw.demo.dao.mapper.ext;

import com.xuzw.demo.dao.entity.BidConference;
import com.xuzw.demo.dao.entity.BidCongerenceConferee;
import com.xuzw.demo.dao.entity.BidCongerenceConfereeModel;
import com.xuzw.demo.dao.entity.BidCongerenceIdeaModel;
import com.xuzw.demo.dao.entity.BidCongerenceTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BidCongerenceTopicExtMapper {

    /**
     * 传入会议主键id 统计决议结果
     * @param conferenceId
     * @return
     */
    List<BidCongerenceIdeaModel> statisticalAnalysis(@Param("conferenceId") Long conferenceId);

    /**
     * 查询所有议题
     * @param conferenceId
     * @return
     */
    List<BidCongerenceTopic> queryBidCongerenceTopicByConferenceId(@Param("conferenceId") Long conferenceId);

    /**
     * 查询会议小组成员
     * @param conferenceId
     * @return
     */
    List<BidCongerenceConfereeModel> queryBidCongerenceConfereeList(@Param("conferenceId") Long conferenceId);

    /**
     *
     * @param userId
     * @return
     */
    List<BidConference> queryBidConferenceList(@Param("userId") Long userId, @Param("createUserId") Long createUserId);


}
