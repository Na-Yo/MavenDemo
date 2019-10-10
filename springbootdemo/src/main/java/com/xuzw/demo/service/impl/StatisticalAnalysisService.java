package com.xuzw.demo.service.impl;

import com.xuzw.demo.dao.entity.BidConference;
import com.xuzw.demo.dao.entity.BidCongerenceConfereeModel;
import com.xuzw.demo.dao.entity.BidCongerenceIdeaModel;
import com.xuzw.demo.dao.entity.BidCongerenceTopic;
import com.xuzw.demo.dao.entity.IdeaResultModel;
import com.xuzw.demo.dao.mapper.BidConferenceMapper;
import com.xuzw.demo.dao.mapper.BidCongerenceIdeaMapper;
import com.xuzw.demo.dao.mapper.BidCongerenceTopicMapper;
import com.xuzw.demo.dao.mapper.ext.BidCongerenceTopicExtMapper;
import com.xuzw.demo.service.AMixedMajoritarianStrategy;
import com.xuzw.demo.service.OneTicketVetoStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@Transactional
@RequestMapping("/statisticalAnalysisService")
public class StatisticalAnalysisService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BidConferenceMapper bidConferenceMapper;

    @Autowired
    private BidCongerenceIdeaMapper bidCongerenceIdeaMapper;

    @Autowired
    private BidCongerenceTopicMapper bidCongerenceTopicMapper;

    @Autowired
    private BidCongerenceTopicExtMapper bidCongerenceTopicExtMapper;

    private final String roleName="(主任)";

    /**
     * 会议汇总页面
     * @param conferenceId
     * @return
     */
    @RequestMapping("/resolutionSummary")
    public List statisticalAnalysisService(@RequestParam("conferenceId")Long conferenceId){
        //会议主信息
        BidConference bidConference = bidConferenceMapper.selectByPrimaryKey(conferenceId);
        String resolutionRule = bidConference.getResolutionRule();
        //参会人员
        String CongerenceConfereeString = getCongerenceConfereeString(conferenceId);

        //查询所有议题
        List<BidCongerenceTopic> bidCongerenceTopicList = bidCongerenceTopicExtMapper.queryBidCongerenceTopicByConferenceId(conferenceId);
        //议题分组
        if(bidCongerenceTopicList !=null && bidCongerenceTopicList.size() > 0){
            Map<String, List<BidCongerenceTopic>> congerenceTopicListMapByTopicType = bidCongerenceTopicList.stream().collect(Collectors.groupingBy(BidCongerenceTopic::getTopicType));
        }

        //查询所有议题的每个人的意见
        List<BidCongerenceIdeaModel> bidCongerenceIdeaList = bidCongerenceTopicExtMapper.statisticalAnalysis(conferenceId);
        //获取每个议题统计结果
        List<IdeaResultModel> ideaResultList = getIdeaResultList(resolutionRule, bidCongerenceIdeaList);
        return bidCongerenceIdeaList;
    }

    private List<IdeaResultModel> getIdeaResultList(String resolutionRule, List<BidCongerenceIdeaModel> bidCongerenceIdeaList) {
        List<IdeaResultModel> ideaResultList = null;//
        //不为空才走
        if(bidCongerenceIdeaList != null && bidCongerenceIdeaList.size() > 0){
            //根据议题id分组 得到每个议题下所有人的意见集合
            Map<Long, List<BidCongerenceIdeaModel>> bidCongerenceIdeaMapByTopicId = bidCongerenceIdeaList.stream().collect(Collectors.groupingBy(BidCongerenceIdeaModel::getTopicId));
            //议题类型分组 为了获取审议议题意见集合
            Map<String, List<BidCongerenceIdeaModel>> bidCongerenceIdeaMapByTopicType = bidCongerenceIdeaList.stream().collect(Collectors.groupingBy(BidCongerenceIdeaModel::getTopicType));
            //获取审议议题意见集合
            List<BidCongerenceIdeaModel> bidCongerenceIdeaListTopicType10 = bidCongerenceIdeaMapByTopicType.get("10");
            if(bidCongerenceIdeaListTopicType10 != null && bidCongerenceIdeaListTopicType10.size() >0){
                //审议议题集合根据审议议题id分组，为了统计每个审议议题所有人的意见
                Map<Long, List<BidCongerenceIdeaModel>> bidCongerenceIdeaListTopicType10MapByTopicId = bidCongerenceIdeaListTopicType10.stream().collect(Collectors.groupingBy(BidCongerenceIdeaModel::getTopicId));
                final List<IdeaResultModel> ideaResultListTemp = new ArrayList<IdeaResultModel>(bidCongerenceIdeaListTopicType10MapByTopicId.size());
                //遍历分组之后的map 统计出赞成 反对  弃权票数 以议题最后结果
                bidCongerenceIdeaListTopicType10MapByTopicId.forEach((k,v)->{
                    //根据议题意见进行分组统计 计算出票数
                    Map<String, Long> ideaResultMap = v.stream().filter(BidCongerenceIdeaModel -> !StringUtils.isEmpty(BidCongerenceIdeaModel.getTopicEvaluate()))
                            .collect(Collectors.groupingBy(BidCongerenceIdeaModel::getTopicEvaluate, Collectors.counting()));
                    IdeaResultModel ideaResultModel = new IdeaResultModel();
                    ideaResultModel.setTopicId(k);
                    ideaResultModel.setIdeaResultMap(ideaResultMap);
                    //策略执行
                    CalculatorStrategyContext calculatorStrategyContext = new CalculatorStrategyContext();
                    if("10".equals(resolutionRule)){//少数服从多数
                        calculatorStrategyContext.setCalculatorStrategy(new AMixedMajoritarianStrategy(ideaResultModel));//少数服从多数
                    }else{
                        calculatorStrategyContext.setCalculatorStrategy(new OneTicketVetoStrategy(ideaResultModel));//一票否决
                    }
                    //计算议题投票结果
                    calculatorStrategyContext.calculator();
                    ideaResultListTemp.add(ideaResultModel);
                });
                ideaResultList=ideaResultListTemp;
            }
        }
        return ideaResultList;
    }

    /**
     * 会议决议
     * @param conferenceId
     * @return
     */
    @RequestMapping("/conferenceResolution")
    public Object conferenceResolution(@RequestParam("conferenceId")Long conferenceId){
        logger.debug("========"+conferenceId);
        Long userId=1L;
        //会议主信息
        BidConference bidConference = bidConferenceMapper.selectByPrimaryKey(conferenceId);
        //参会人员 待查
        String CongerenceConfereeString = getCongerenceConfereeString(conferenceId);

        //所有议题集合
        Map<String, List<BidCongerenceTopic>> congerenceTopicListMapByTopicType = null;
        //查询所有议题
        List<BidCongerenceTopic> bidCongerenceTopicList = bidCongerenceTopicExtMapper.queryBidCongerenceTopicByConferenceId(conferenceId);
        //议题分组
        if(bidCongerenceTopicList !=null && bidCongerenceTopicList.size() > 0){
            congerenceTopicListMapByTopicType = bidCongerenceTopicList.stream().collect(Collectors.groupingBy(BidCongerenceTopic::getTopicType));
        }

        //查询所有议题的每个人的意见
        List<BidCongerenceIdeaModel> bidCongerenceIdeaList = bidCongerenceTopicExtMapper.statisticalAnalysis(conferenceId);
        //过滤只留自己的
        List<BidCongerenceIdeaModel> bidCongerenceIdeaListByUserId = bidCongerenceIdeaList.stream().filter(idea -> idea.getUserId().compareTo(userId) == 0).collect(Collectors.toList());
        //当前登录人的意见map集合
        Map<Long, BidCongerenceIdeaModel> bidCongerenceIdeaMapByTopicId = bidCongerenceIdeaListByUserId.stream().collect(Collectors.toMap(BidCongerenceIdeaModel::getTopicId, Function.identity()));

        return CongerenceConfereeString;
    }

    /**
     * 获取参会人员的字符串拼接
     * @param conferenceId
     * @return
     */
    private String getCongerenceConfereeString(@RequestParam("conferenceId") Long conferenceId) {
        List<BidCongerenceConfereeModel> bidCongerenceConfereeList = bidCongerenceTopicExtMapper.queryBidCongerenceConfereeList(conferenceId);
        String congerenceConfereeString = bidCongerenceConfereeList.stream().map(e -> {
            if("1".equals(e.getGroupDirector())){
                return e.getTrueName()+roleName;
            }else{
                return e.getTrueName();
            }
        }).collect(Collectors.joining(";"));
        return congerenceConfereeString;
    }


    @RequestMapping("/queryConferenceList")
    public Object queryConferenceList(){
        Long userId=1L;
        //我参与的会议集合
        List<BidConference> bidConferenceList = bidCongerenceTopicExtMapper.queryBidConferenceList(userId, null);
        return bidConferenceList;
    };

    @RequestMapping("/submitResolution")
    public Object submitResolution(HttpServletRequest request){
        Long userId=1L;
        Long conferenceId = Long.valueOf(request.getParameter("conferenceId"));
        //查询所有议题的每个人的意见
        List<BidCongerenceIdeaModel> bidCongerenceIdeaList = bidCongerenceTopicExtMapper.statisticalAnalysis(conferenceId);
        //过滤只留自己的
        List<BidCongerenceIdeaModel> bidCongerenceIdeaListByUserId = bidCongerenceIdeaList.stream().filter(idea -> idea.getUserId().compareTo(userId) == 0).collect(Collectors.toList());
        if(bidCongerenceIdeaListByUserId != null){
            //获取页面的值 填充
            bidCongerenceIdeaListByUserId.stream().forEach(bidCongerenceIdea->{
                Long bidCongerenceTopicId = bidCongerenceIdea.getId();
                String topicEvaluateName = new StringBuilder().append("topicEvaluate").append("_").append(bidCongerenceTopicId).toString();
                String topicEvaluate = request.getParameter(topicEvaluateName);
                bidCongerenceIdea.setTopicEvaluate(topicEvaluate);
                String definiteIdeaName = new StringBuilder().append("definiteIdea").append("_").append(bidCongerenceTopicId).toString();
                String definiteIdea = request.getParameter(definiteIdeaName);
                bidCongerenceIdea.setDefiniteIdea(definiteIdea);
            });
        }
        //当前时间
        Date date = new Date();
        bidCongerenceIdeaListByUserId.forEach(bidCongerenceIdea ->{
            bidCongerenceIdea.setUpdateTime(date);
            bidCongerenceIdeaMapper.updateByPrimaryKey(bidCongerenceIdea);
        });


        //获取每个议题统计结果
        BidConference bidConference = bidConferenceMapper.selectByPrimaryKey(conferenceId);
        String resolutionRule = bidConference.getResolutionRule();
        List<IdeaResultModel> ideaResultList = getIdeaResultList(resolutionRule, bidCongerenceIdeaList);
        //拼装议题结果集合
        List<BidCongerenceTopic> bidCongerenceTopicResultList = ideaResultList.stream().map(e -> {
            BidCongerenceTopic bidCongerenceTopic = new BidCongerenceTopic();
            bidCongerenceTopic.setId(e.getTopicId());
            bidCongerenceTopic.setTopicCollect(e.getResult());
            bidCongerenceTopic.setUpdateTime(date);
            bidCongerenceTopic.setUpdateUserId(userId);
            return bidCongerenceTopic;
        }).collect(Collectors.toList());
        //更新每个议题的决议结果
        bidCongerenceTopicResultList.stream().forEach(e->{
            bidCongerenceTopicMapper.updateByPrimaryKeySelective(e);
        });
        return conferenceId;
    }

    /**
     * 主任提交整体意见
     * @param request
     * @return
     */
    @RequestMapping("/submitTopicRemark")
    public Object submitTopicRemark(HttpServletRequest request){
        Long conferenceId = Long.valueOf(request.getParameter("conferenceId"));
        String topicRemark = request.getParameter("topicRemark");
        Date date = new Date();
        BidConference bidConference = bidConferenceMapper.selectByPrimaryKey(conferenceId);
        bidConference.setTopicFlag("1");
        bidConference.setTopicRemark(topicRemark);
        bidConference.setUpdateTime(date);
        bidConferenceMapper.updateByPrimaryKey(bidConference);
        return bidConference;
    }


    /**
     * 校验是否可以将汇总记录推送
     * @param request
     * @return
     */
    @RequestMapping("/checkPushSummary")
    public Object checkPushSummary(HttpServletRequest request){
        Boolean checkFlag= true;
        Long conferenceId = Long.valueOf(request.getParameter("conferenceId"));
        //查询所有议题的每个人的意见
        List<BidCongerenceIdeaModel> bidCongerenceIdeaList = bidCongerenceTopicExtMapper.statisticalAnalysis(conferenceId);
        String noResponseCongerenceConferee = null;//未决议的人
        if(bidCongerenceIdeaList != null) {
            Set<String> collect = bidCongerenceIdeaList.stream().filter(e -> StringUtils.isEmpty(e.getTopicEvaluate())).map(e -> {
                return e.getTrueName();
            }).collect(Collectors.toSet());
            if(collect !=null){
                noResponseCongerenceConferee = collect.stream().collect(Collectors.joining(","));
            }
        }

        //没有人未响应
        if(StringUtils.isEmpty(noResponseCongerenceConferee)){
            //查询所有议题
            List<BidCongerenceTopic> bidCongerenceTopicList = bidCongerenceTopicExtMapper.queryBidCongerenceTopicByConferenceId(conferenceId);
            String noResultCongerenceTopic = bidCongerenceTopicList.stream().filter(e -> {
                return StringUtils.isEmpty(e.getTopicCollect());
            }).map(e->{return e.getTopicName();}).collect(Collectors.joining(";"));
            if(StringUtils.isNotEmpty(noResultCongerenceTopic)){
                checkFlag = false;
                return noResultCongerenceTopic;
            }
        }else{
            checkFlag = false;
            return noResponseCongerenceConferee;
        }
        return checkFlag;
    }
}
