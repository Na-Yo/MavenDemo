package com.xuzw.demo.rabbitmq.producer;

import com.xuzw.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiPaymentSender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void order(String msg){
        logger.info("api.payment.order send message: "+msg);
        rabbitTemplate.convertAndSend(RabbitConfig.PAYMENT_EXCHANGE, "api.payment.order", msg);
    }

    public void orderQuery(String msg){
        logger.info("api.payment.order.query send message: "+msg);
        rabbitTemplate.convertAndSend(RabbitConfig.PAYMENT_EXCHANGE, "api.payment.order.query", msg);
    }

    public void orderDetailQuery(String msg){
        logger.info("api.payment.order.detail.query send message: "+msg);
        rabbitTemplate.convertAndSend(RabbitConfig.PAYMENT_EXCHANGE, "api.payment.order.detail.query", msg);
    }
}
