package com.belong.smart.controller;


import com.belong.smart.entity.ResultBean;
import com.belong.smart.service.impl.ServiceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 轮播图 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-16
 */
@Api(tags = "04、服务")
@RestController
@RequestMapping("/04_all-service")
public class ServiceController {
    @Autowired
    ServiceServiceImpl service;

    @ApiOperation("4.1 查询服务一级分类")
    @GetMapping("/list1")
    public ResultBean getOneService() {
        return ResultBean.success(service.findOneService());
    }

    @ApiOperation("4.2 查询全部服务")
    @GetMapping("/list2")
    public ResultBean getAllService() {
        return ResultBean.success(service.list());
    }
}
