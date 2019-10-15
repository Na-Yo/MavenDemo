package com.xuzw.demo.rabbitmq.receiver;

import com.xuzw.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.API_CORE)
public class ApiCoreReceive {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void receive(String msg) {
        logger.info(RabbitConfig.API_CORE+" receive message: "+msg);
    }
}
