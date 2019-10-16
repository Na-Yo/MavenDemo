package com.xuzw.Test;

import com.xuzw.demo.rabbitmq.producer.ApiReportSender;
import com.xuzw.springbootdemo.SpringbootdemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemoApplication.class)
public class ApiReportSenderTests {

    @Autowired
    private ApiReportSender apiReportSender;

    @Test
    public void test_generateReports() {
        apiReportSender.generateReports("开始生成报表！");
    }
}
