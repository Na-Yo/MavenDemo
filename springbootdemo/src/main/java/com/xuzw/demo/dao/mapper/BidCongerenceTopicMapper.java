package com.xuzw.demo.dao.mapper;

import com.xuzw.demo.dao.entity.BidCongerenceTopic;

public interface BidCongerenceTopicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BidCongerenceTopic record);

    int insertSelective(BidCongerenceTopic record);

    BidCongerenceTopic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BidCongerenceTopic record);

    int updateByPrimaryKey(BidCongerenceTopic record);
}