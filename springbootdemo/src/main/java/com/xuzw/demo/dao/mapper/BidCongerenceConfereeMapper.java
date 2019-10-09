package com.xuzw.demo.dao.mapper;

import com.xuzw.demo.dao.entity.BidCongerenceConferee;

public interface BidCongerenceConfereeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BidCongerenceConferee record);

    int insertSelective(BidCongerenceConferee record);

    BidCongerenceConferee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BidCongerenceConferee record);

    int updateByPrimaryKey(BidCongerenceConferee record);
}