package com.xuzw.demo.service;

import com.xuzw.demo.dao.entity.IdeaResultModel;

public class OneTicketVetoStrategy implements CalculatorStrategy {
    private IdeaResultModel ideaResultModel;

    public OneTicketVetoStrategy(IdeaResultModel ideaResultModel) {
        this.ideaResultModel = ideaResultModel;
    }

    /**
     * 一票否决
     * @return
     */
    @Override
    public void exec() {
        Long agreeNum = ideaResultModel.getIdeaResultMap().get("10");//赞同
        Long notAgreeNum = ideaResultModel.getIdeaResultMap().get("20");//否决
        Long waiverNum = ideaResultModel.getIdeaResultMap().get("30");//弃权

        //都为空 说明没有人提交决议 无结果
        if(agreeNum == null && notAgreeNum == null && waiverNum == null){
            ideaResultModel.setResult("");
            return;
        }

        //否决 或者 弃权有一个有值 则结果为否决
        if(notAgreeNum !=null || waiverNum !=null){
            ideaResultModel.setResult("20");
            return;
        }else if(agreeNum != null){
            ideaResultModel.setResult("10");
        }

    }
}
