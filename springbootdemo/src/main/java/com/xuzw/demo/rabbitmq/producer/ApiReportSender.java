package com.xuzw.demo.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApiReportSender implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ApiReportSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate=rabbitTemplate;
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback(this);
    }

    public void generateReports(String msg){
        logger.info("api.generate.reports send message: "+msg);
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("reportExchange", "api.generate.reports", msg,correlationId);
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info(Thread.currentThread()+"回调id:" + correlationData);
        if (ack) {
            logger.info(Thread.currentThread()+"消息发送成功");
        } else {
            logger.info(Thread.currentThread()+"消息发送失败:" + cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        logger.info(Thread.currentThread()+"message=" + message+"=replyCode="+replyCode+"=replyText="+replyText+"=exchange="+exchange+"=routingKey="+routingKey);
    }
}
