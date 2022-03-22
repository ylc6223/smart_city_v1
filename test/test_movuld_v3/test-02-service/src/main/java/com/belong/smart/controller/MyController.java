package com.belong.smart.controller;

import com.belong.smart.entity.AllService;
import com.belong.smart.service.impl.AllServiceServiceImpl_02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    AllServiceServiceImpl_02 service;

    @GetMapping("/test02")
    public List<AllService> test02() {
        return service.findAll();
    }
}
