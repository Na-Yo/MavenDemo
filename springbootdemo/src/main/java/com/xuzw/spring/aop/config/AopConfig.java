package com.xuzw.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.xuzw.spring")
@EnableAspectJAutoProxy
public class AopConfig {
}
