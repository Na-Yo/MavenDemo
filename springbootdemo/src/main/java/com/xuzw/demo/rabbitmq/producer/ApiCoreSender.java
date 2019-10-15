package com.xuzw.demo.rabbitmq.producer;

import com.xuzw.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiCoreSender {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg){
        logger.info(RabbitConfig.API_CORE+".user send message: "+msg);
        rabbitTemplate.convertAndSend(RabbitConfig.CORE_EXCHANGE, "api.core.user", msg);
    }

    public void userQuery(String msg){
        logger.info(RabbitConfig.API_CORE+".user.query send message: "+msg);
        rabbitTemplate.convertAndSend(RabbitConfig.CORE_EXCHANGE, "api.core.user.query", msg);
    }
}
