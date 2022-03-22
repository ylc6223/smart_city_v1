package com.belong.smart.controller;


import com.belong.smart.entity.AllService;
import com.belong.smart.service.impl.AllServiceServiceImpl_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 全部服务表 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@RestController
public class MyController_03 {
    @Autowired
    AllServiceServiceImpl_3 service;

    @GetMapping("/test03")
    public List<AllService> test03() {
        return service.findAll();
    }

    //@GetMapping("/test03")
    //public String test03() {
    //    return "ok";
    //}
}
