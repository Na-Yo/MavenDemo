package com.xuzw.Test;

import com.xuzw.demo.rabbitmq.producer.ApiCoreSender;
import com.xuzw.springbootdemo.SpringbootdemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemoApplication.class)
public class ApiCoreSenderTests {
    @Autowired
    private ApiCoreSender apiCoreSender;

    @Test
    public void test_user() {
        apiCoreSender.user("用户管理！");
    }

    @Test
    public void test_userQuery() {
        apiCoreSender.userQuery("查询用户信息！");
    }
}
