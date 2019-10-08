package com.xuzw.demo.dao.entity;

import java.util.Date;

public class BidConference {
    private Long id;

    private String conferenceName;

    private Date conferenceBeginTime;

    private Date conferenceEndTime;

    private String conferenceType;

    private String resolutionRule;

    private String remark;

    private String conferenceOutline;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Long updateUserId;

    private String isDeleted;

    private String conferenceFileId;

    private String summaryFileId;

    private String confenerceStatus;

    private String topicFlag;

    private Long pushUserId;

    private String topicRemark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName == null ? null : conferenceName.trim();
    }

    public Date getConferenceBeginTime() {
        return conferenceBeginTime;
    }

    public void setConferenceBeginTime(Date conferenceBeginTime) {
        this.conferenceBeginTime = conferenceBeginTime;
    }

    public Date getConferenceEndTime() {
        return conferenceEndTime;
    }

    public void setConferenceEndTime(Date conferenceEndTime) {
        this.conferenceEndTime = conferenceEndTime;
    }

    public String getConferenceType() {
        return conferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.conferenceType = conferenceType == null ? null : conferenceType.trim();
    }

    public String getResolutionRule() {
        return resolutionRule;
    }

    public void setResolutionRule(String resolutionRule) {
        this.resolutionRule = resolutionRule == null ? null : resolutionRule.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getConferenceOutline() {
        return conferenceOutline;
    }

    public void setConferenceOutline(String conferenceOutline) {
        this.conferenceOutline = conferenceOutline == null ? null : conferenceOutline.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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

    public String getConferenceFileId() {
        return conferenceFileId;
    }

    public void setConferenceFileId(String conferenceFileId) {
        this.conferenceFileId = conferenceFileId == null ? null : conferenceFileId.trim();
    }

    public String getSummaryFileId() {
        return summaryFileId;
    }

    public void setSummaryFileId(String summaryFileId) {
        this.summaryFileId = summaryFileId == null ? null : summaryFileId.trim();
    }

    public String getConfenerceStatus() {
        return confenerceStatus;
    }

    public void setConfenerceStatus(String confenerceStatus) {
        this.confenerceStatus = confenerceStatus == null ? null : confenerceStatus.trim();
    }

    public String getTopicFlag() {
        return topicFlag;
    }

    public void setTopicFlag(String topicFlag) {
        this.topicFlag = topicFlag == null ? null : topicFlag.trim();
    }

    public Long getPushUserId() {
        return pushUserId;
    }

    public void setPushUserId(Long pushUserId) {
        this.pushUserId = pushUserId;
    }

    public String getTopicRemark() {
        return topicRemark;
    }

    public void setTopicRemark(String topicRemark) {
        this.topicRemark = topicRemark == null ? null : topicRemark.trim();
    }
}