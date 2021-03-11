package com.xuzw.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuziwen
 */
@SpringBootApplication(scanBasePackages = {"com.xuzw"})
@MapperScan("com.xuzw.demo.dao.mapper")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
