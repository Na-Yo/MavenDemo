package com.xuzw.demo.dao.mapper;

import com.xuzw.demo.dao.entity.BidConference;

public interface BidConferenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BidConference record);

    int insertSelective(BidConference record);

    BidConference selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BidConference record);

    int updateByPrimaryKey(BidConference record);
}