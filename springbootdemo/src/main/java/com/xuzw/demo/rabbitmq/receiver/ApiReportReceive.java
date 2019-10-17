package com.xuzw.demo.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import com.xuzw.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApiReportReceive {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RabbitHandler
    @RabbitListener(queues = RabbitConfig.API_REPORT_PAYMENT)
    public void payment(String msg, Channel channel, Message message) {
        //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        logger.info("api.report.payment receive message: "+msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            logger.error("receiver fail",e);
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
        }
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitConfig.API_REPORT_REFUND)
    public void refund(String msg, Channel channel, Message message) {
        logger.info("api.report.refund receive message: "+msg);
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            logger.error("receiver fail",e);
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
        }
    }
}
