package com.xuzw.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xuzw"})
@MapperScan("com.xuzw.demo.dao.mapper")
public class SpringbootdemoApplication {

	public static void main(String[] args) {
	    SpringApplication.run(SpringbootdemoApplication.class, args);
	}

}
