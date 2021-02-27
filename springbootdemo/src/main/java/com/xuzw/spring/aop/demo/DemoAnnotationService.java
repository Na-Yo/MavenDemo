package com.xuzw.spring.aop.demo;

import com.xuzw.spring.aop.config.AnnotationAspect;
import org.springframework.stereotype.Service;
/**
 * @author xuziwen
 */
@Service
public class DemoAnnotationService {
    @AnnotationAspect(name = "注解式拦截的add操作")
    public Integer add() {
        System.out.println("真正执行到了DemoAnnotationService的add方法");
        System.out.println("DemoAnnotationService.add方法结束");
        return 1;
    }
}
