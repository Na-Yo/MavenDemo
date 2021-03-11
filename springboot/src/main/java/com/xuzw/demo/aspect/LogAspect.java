package com.xuzw.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author xuziwen
 * @date 2021/3/11 7:30 下午
 */
@Component
@Aspect
public class LogAspect {


    @Pointcut("@annotation(com.xuzw.demo.aspect.AnnotationAspect)")
    public void annotationPointCut() {
        System.out.println("annotationPointCut");
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("before-方法规则式拦截，" + method.getName());
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        AnnotationAspect annotationAspect = method.getAnnotation(AnnotationAspect.class);
        System.out.println("after-注解式拦截" + annotationAspect.name());
    }

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        AnnotationAspect annotationAspect = method.getAnnotation(AnnotationAspect.class);
        System.out.println("around start-注解式拦截" + annotationAspect.name());
        Object proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        System.out.println("around end-注解式拦截" + annotationAspect.name());
        return proceed;
    }

    @AfterReturning(value="annotationPointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        AnnotationAspect annotationAspect = method.getAnnotation(AnnotationAspect.class);
        System.out.println("AfterReturning-注解式拦截" + annotationAspect.name()+",结果是："+result);
    }

    @AfterThrowing(value="annotationPointCut()",throwing = "e")
    public void afterReturning(JoinPoint joinPoint,Exception e){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        AnnotationAspect annotationAspect = method.getAnnotation(AnnotationAspect.class);
        System.out.println("AfterReturning-注解式拦截" + annotationAspect.name()+",异常是："+e.getMessage());
    }

    /*@Before("execution(* com.xuzw.spring.aop.demo.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("before-方法规则式拦截，" + method.getName());
    }*/
}
