package com.xuzw.demo.rabbitmq.receiver;

import com.xuzw.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.API_PAYMENT)
public class ApiPaymentReceive {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void receive(String msg) {
        logger.info(RabbitConfig.API_PAYMENT+" receive message: "+msg);
    }
}
