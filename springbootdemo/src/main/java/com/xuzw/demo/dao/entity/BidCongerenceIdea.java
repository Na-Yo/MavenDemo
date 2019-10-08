package com.xuzw.demo.dao.entity;

import java.util.Date;

public class BidCongerenceIdea {
    private Long id;

    private Long conferenceId;

    private Long topicId;

    private Long confereeId;

    private String topicEvaluate;

    private String definiteIdea;

    private Long userId;

    private Date createTime;

    private Long createUserId;

    private Date updateTime;

    private Long updateUserId;

    private String isDeleted;

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

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getConfereeId() {
        return confereeId;
    }

    public void setConfereeId(Long confereeId) {
        this.confereeId = confereeId;
    }

    public String getTopicEvaluate() {
        return topicEvaluate;
    }

    public void setTopicEvaluate(String topicEvaluate) {
        this.topicEvaluate = topicEvaluate == null ? null : topicEvaluate.trim();
    }

    public String getDefiniteIdea() {
        return definiteIdea;
    }

    public void setDefiniteIdea(String definiteIdea) {
        this.definiteIdea = definiteIdea == null ? null : definiteIdea.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }
}