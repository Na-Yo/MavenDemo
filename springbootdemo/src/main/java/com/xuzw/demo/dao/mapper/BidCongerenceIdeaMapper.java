package com.xuzw.demo.dao.mapper;

import com.xuzw.demo.dao.entity.BidCongerenceIdea;

public interface BidCongerenceIdeaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BidCongerenceIdea record);

    int insertSelective(BidCongerenceIdea record);

    BidCongerenceIdea selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BidCongerenceIdea record);

    int updateByPrimaryKey(BidCongerenceIdea record);
}