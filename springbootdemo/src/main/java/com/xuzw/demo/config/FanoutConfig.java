package com.xuzw.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    @Bean
    public Queue reportPaymentQueue() {
        return new Queue(RabbitConfig.API_REPORT_PAYMENT);
    }

    @Bean
    public Queue reportRefundQueue() {
        return new Queue(RabbitConfig.API_REPORT_REFUND);
    }

    @Bean
    public FanoutExchange reportExchange() {
        return new FanoutExchange(RabbitConfig.REPORT_EXCHANGE);
    }

    @Bean
    public Binding bindingReportPaymentExchange(Queue reportPaymentQueue, FanoutExchange reportExchange) {
        return BindingBuilder.bind(reportPaymentQueue).to(reportExchange);
    }

    @Bean
    public Binding bindingReportRefundExchange(Queue reportRefundQueue, FanoutExchange reportExchange) {
        return BindingBuilder.bind(reportRefundQueue).to(reportExchange);
    }
}