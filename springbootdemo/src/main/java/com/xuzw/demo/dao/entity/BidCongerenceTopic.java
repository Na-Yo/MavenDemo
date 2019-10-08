package com.xuzw.demo.dao.entity;

import java.util.Date;

public class BidCongerenceTopic {
    private Long id;

    private Long conferenceId;

    private String topicItem;

    private String topicType;

    private String topicName;

    private String isDeleted;

    private Date createTime;

    private Long createUserId;

    private Date updateTime;

    private Long updateUserId;

    private String topicCollect;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Long conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getTopicItem() {
        return topicItem;
    }

    public void setTopicItem(String topicItem) {
        this.topicItem = topicItem == null ? null : topicItem.trim();
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType == null ? null : topicType.trim();
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getTopicCollect() {
        return topicCollect;
    }

    public void setTopicCollect(String topicCollect) {
        this.topicCollect = topicCollect == null ? null : topicCollect.trim();
    }
}