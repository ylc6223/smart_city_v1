package com.belong.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 配置包扫描路径，扫描com.belong下所有文件
@SpringBootApplication(scanBasePackages = {"com.belong.**"})
//@SpringBootApplication()
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}




