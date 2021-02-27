package com.xuzw.spring.ioc;

import com.xuzw.spring.aop.config.AopConfig;
import com.xuzw.spring.model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xuziwen
 */
public class IocDebug {
    public static void main(String[] args) {
        /*        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");*/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Student bean = (Student)context.getBean(Student.class);
    }
}
