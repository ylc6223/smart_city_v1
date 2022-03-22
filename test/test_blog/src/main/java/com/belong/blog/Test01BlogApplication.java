package com.belong.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Test01BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test01BlogApplication.class, args);
    }

}
