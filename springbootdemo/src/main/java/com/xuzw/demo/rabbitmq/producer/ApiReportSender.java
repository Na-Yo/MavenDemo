package com.xuzw.demo.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApiReportSender implements RabbitTemplate.ConfirmCallback{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

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
            logger.info(Thread.currentThread()+"消息成功消费");
        } else {
            logger.info(Thread.currentThread()+"消息消费失败:" + cause);
        }
    }
}
