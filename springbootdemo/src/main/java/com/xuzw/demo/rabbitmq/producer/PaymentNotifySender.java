package com.xuzw.demo.rabbitmq.producer;

import com.xuzw.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentNotifySender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender(String msg){
        logger.info("notify.payment send message: "+msg);
        rabbitTemplate.convertAndSend(RabbitConfig.API_PAYMENT, msg);
    }
}
