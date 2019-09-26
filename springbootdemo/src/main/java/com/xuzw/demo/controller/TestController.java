package com.xuzw.demo.controller;

import com.xuzw.demo.dao.mapper.TestMapper;
import com.xuzw.demo.lock.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import com.xuzw.demo.util.RedisUtil;

@RestController
@RequestMapping("/testController")
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisLock redisLock;

    @RequestMapping("/testDB")
    public void testDB(){
        System.out.println("======开始======");
        Map<String, Object> map = testMapper.testSelect();
        System.out.println("======结束======");
    }

    @RequestMapping("/testRedis")
    public String testRedis(){
        System.out.println("=====setRedis start======");
        redisUtil.addKey("test","测试一下啊",5L, TimeUnit.MINUTES);
        System.out.println("=====setRedis end========");
        return redisUtil.getValue("test") != null? redisUtil.getValue("test").toString():null;
    }

    @RequestMapping("/testRedisDynamicSet")
    public String testRedisDynamicSet(@RequestParam("name") String name){
        System.out.println("=====setRedis start======");
        redisUtil.addKey("test",name,5L, TimeUnit.MINUTES);
        System.out.println("=====setRedis end========");
        return redisUtil.getValue("test") != null? redisUtil.getValue("test").toString():null;
    }

    @RequestMapping("/testRedisLock")
    public String testRedisLock(@RequestParam("name") String name){
        System.out.println(Thread.currentThread()+"=====获取锁开始======");
        String token = redisLock.lock(name, 1,10000);//超时一分钟
        try {
            if(token !=null){//代表加锁成功
                System.out.println(Thread.currentThread()+"=====获取锁成功======");
                Thread.sleep(20000); //try 50 per sec
                redisLock.unlock(name,token);
                System.out.println(Thread.currentThread()+"=====释放锁成功======");
            }else{//加了很久 加锁失败
                System.out.println(Thread.currentThread()+"=====获取锁失败========");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(token!=null) {
                redisLock.unlock(name, token);
            }
        }
        System.out.println(Thread.currentThread()+"=====end========");
        return redisUtil.getValue("test") != null? redisUtil.getValue("test").toString():null;
    }
}
