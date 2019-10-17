package com.xuzw.demo.controller;

import com.xuzw.demo.rabbitmq.producer.ApiReportSender;
import com.xuzw.demo.rabbitmq.producer.MsgProducer;
import com.xuzw.demo.rabbitmq.producer.PaymentNotifySender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testRabbitMq")
public class TestRabbitMq {

    /*@Autowired
    private MsgProducer msgProducer;*/

    @Autowired
    private PaymentNotifySender paymentNotifySender;

    @Autowired
    private ApiReportSender apiReportSender;

    @RequestMapping("/testMqContent")
    public String TestMq(@RequestParam("content") String content){
//        msgProducer.sendMsgDirect(content);
        paymentNotifySender.sender(content);
        apiReportSender.generateReports(content);
        return "ok";
    }
}
