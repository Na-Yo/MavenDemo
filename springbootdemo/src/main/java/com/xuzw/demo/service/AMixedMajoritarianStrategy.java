package com.xuzw.demo.service;

import com.xuzw.demo.dao.entity.IdeaResultModel;

public class AMixedMajoritarianStrategy implements CalculatorStrategy {

    private IdeaResultModel ideaResultModel;

    public AMixedMajoritarianStrategy(IdeaResultModel ideaResultModel) {
        this.ideaResultModel = ideaResultModel;
    }

    /**
     * 少数服从多数
     * @return
     */
    @Override
    public void exec() {
        Long agreeNum = ideaResultModel.getIdeaResultMap().get("10");//赞同
        Long notAgreeNum = ideaResultModel.getIdeaResultMap().get("20");//否决
        Long waiverNum = ideaResultModel.getIdeaResultMap().get("30");//弃权

        //为null置0
        agreeNum= agreeNum== null?0L:agreeNum;
        notAgreeNum= notAgreeNum== null?0L:notAgreeNum;
        waiverNum= waiverNum== null?0L:waiverNum;
        int compare = agreeNum.compareTo(notAgreeNum + waiverNum);
        if(compare >0){//赞同数量多
            ideaResultModel.setResult("10");
        }else if(compare < 0){//否决
            ideaResultModel.setResult("20");
        }else if(compare == 0){//数量相等
            ideaResultModel.setResult("");
        }

    }
}
