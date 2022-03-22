package com.belong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.belong.**.mapper")
@SpringBootApplication
public class TestMpApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestMpApplication.class, args);
    }

}
