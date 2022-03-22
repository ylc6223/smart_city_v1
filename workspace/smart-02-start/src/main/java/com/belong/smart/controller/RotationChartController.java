package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.RotationChart;
import com.belong.smart.service.impl.RotationChartServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 轮播图 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-16
 */
@Api(tags = "02、引导页")
@RestController
@RequestMapping("/belong")
public class RotationChartController {
    @Autowired
    RotationChartServiceImpl rotationChartService;

    @ApiOperation("2.1 引导页轮播图列表")
    @GetMapping("/userinfo/rotation/lists")
    public ResultBean start(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam int type) {
        QueryWrapper<RotationChart> wrapper = new QueryWrapper<RotationChart>().eq("type", type);
        Page<RotationChart> page = rotationChartService.page(new Page<>(pageNum, pageSize), wrapper);
        return  ResultBean.success(page);
    }


    @GetMapping("/test01")
    public List<String> test01() {
        return  rotationChartService.selectUrl();
    }


}
