package com.xuzw.Test;

import com.xuzw.demo.rabbitmq.producer.MsgProducer;
import com.xuzw.springbootdemo.SpringbootdemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemoApplication.class)
public class MsgProducerTest {

    @Autowired
    private MsgProducer msgProducer;

    @Test
    public void test_msg(){
        msgProducer.sendMsg("测试msg");
    }
}
