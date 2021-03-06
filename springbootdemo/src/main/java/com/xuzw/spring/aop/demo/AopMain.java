package com.xuzw.spring.aop.demo;

import com.xuzw.spring.aop.config.AopConfig;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "cglib");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        demoAnnotationService.add();//基于注解的拦截
//        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
//        demoMethodService.add();//给予方法规则的拦截
    }
}
