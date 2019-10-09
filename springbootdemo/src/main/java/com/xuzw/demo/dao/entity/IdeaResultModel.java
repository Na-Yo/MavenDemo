package com.xuzw.demo.dao.entity;

import java.util.Map;

public class IdeaResultModel {
    private Long topicId;//会议id

    private Map<String,Long> ideaResultMap;//结果集合

    private String result; //最终结果 值集

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, Long> getIdeaResultMap() {
        return ideaResultMap;
    }

    public void setIdeaResultMap(Map<String, Long> ideaResultMap) {
        this.ideaResultMap = ideaResultMap;
    }
}