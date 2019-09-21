package com.xuzw.demo.controller;

import com.xuzw.demo.dao.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/testController")
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("/testDB")
    public void testDB(){
        System.out.println("======开始======");
        Map<String, Object> map = testMapper.testSelect();
        System.out.println("======结束======");
    }

}
