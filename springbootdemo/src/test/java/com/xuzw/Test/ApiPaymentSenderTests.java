package com.xuzw.Test;

import com.xuzw.demo.rabbitmq.producer.ApiPaymentSender;
import com.xuzw.springbootdemo.SpringbootdemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemoApplication.class)
public class ApiPaymentSenderTests {
    @Autowired
    private ApiPaymentSender apiPaymentSender;

    @Test
    public void test_order() {
        apiPaymentSender.order("订单管理！");
    }

    @Test
    public void test_orderQuery() {
        apiPaymentSender.orderQuery("查询订单信息！");
    }

    @Test
    public void test_orderDetailQuery() {
        apiPaymentSender.orderDetailQuery("查询订单详情信息！");
    }
}
