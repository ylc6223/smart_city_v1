package com.belong.module02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.belong.**"})
@SpringBootApplication()
public class Module01HomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(Module01HomeApplication.class, args);
    }
}
