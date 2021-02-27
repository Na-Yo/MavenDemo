package com.xuzw.spring.aop.demo;

import org.springframework.stereotype.Service;

/**
 * @author xuziwen
 */
@Service
public class DemoMethodService {
    public void add() {
        System.out.println("DemoMethodService.add()");
    }
}
