package com.xuzw.demo.service.impl;

import com.xuzw.demo.dao.entity.BidCongerenceIdea;
import com.xuzw.demo.dao.mapper.ext.BidCongerenceTopicExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statisticalAnalysisService")
public class StatisticalAnalysisService {

    @Autowired
    private BidCongerenceTopicExtMapper bidCongerenceTopicExtMapper;

    @RequestMapping("/resolution")
    public List statisticalAnalysisService(@RequestParam("conferenceId")Long conferenceId){
        List<BidCongerenceIdea> bidCongerenceIdeaList = bidCongerenceTopicExtMapper.statisticalAnalysis(conferenceId);
        return bidCongerenceIdeaList;
    }

}
