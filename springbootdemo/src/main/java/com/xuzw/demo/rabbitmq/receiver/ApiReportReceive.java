package com.xuzw.demo.rabbitmq.receiver;

import com.xuzw.demo.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ApiReportReceive {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RabbitHandler
    @RabbitListener(queues = RabbitConfig.API_REPORT_PAYMENT)
    public void payment(String msg) {
        logger.info("api.report.payment receive message: "+msg);
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitConfig.API_REPORT_REFUND)
    public void refund(String msg) {
        logger.info("api.report.refund receive message: "+msg);
    }
}
