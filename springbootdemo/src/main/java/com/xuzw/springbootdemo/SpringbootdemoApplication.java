package com.xuzw.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.xuzw"})
@MapperScan("com.xuzw.demo.dao.mapper")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
public class SpringbootdemoApplication {

	public static void main(String[] args) {
	    SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}
