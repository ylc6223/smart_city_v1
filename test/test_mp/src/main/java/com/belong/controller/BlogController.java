package com.belong.controller;


import com.belong.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-17
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;

    @GetMapping("/test01")
    public Object test01() {
        return blogService.list();
    }

    @GetMapping("/test02")
    public Object test02() {
        return blogService.selectAll();
    }
}
