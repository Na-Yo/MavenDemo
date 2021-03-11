package com.xuzw.demo.controller;

import com.xuzw.demo.aspect.AnnotationAspect;
import com.xuzw.demo.dao.mapper.TestMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**d
 * @author xuziwen
 * @date 2021/3/10 10:24 下午
 */
@RestController
@RequestMapping("/testDB")
public class TestDb {

    @Resource
    private TestMapper testMapper;

    @Transactional
    @RequestMapping("/query")
    @AnnotationAspect
    public String query(){
        return testMapper.testSelect().toString();
    }
}
