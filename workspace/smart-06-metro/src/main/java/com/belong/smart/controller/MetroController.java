package com.belong.smart.controller;


import com.belong.smart.entity.po.MetroSteps;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.vo.MetroDetialBean;
import com.belong.smart.service.impl.MetroServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 地铁城市表 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Api(tags = "06、城市地铁")
@RestController
@RequestMapping("/06_metro")
public class MetroController {
    @Autowired
    MetroServiceImpl service;

    @ApiOperation("6.1 查询地铁站首页 ")
    @GetMapping("/list1")
    public ResultBean fun1(@RequestParam String currentName) {
        return  ResultBean.success(service.getMetroByName(currentName));
    }

    @ApiOperation("6.2 查询地铁站详情 ")
    @GetMapping("/list2/{id}")
    public ResultBean fun2(@PathVariable int id) {
        // 返回结果嵌套实体类
        List<MetroDetialBean> data = service.getMetroDetial(id);
        // 获取嵌套对象的属性值
        List<MetroSteps> metroSteps = service.getMetroSteps(id);
        // 设置结果嵌套实体类的嵌套对象的属性值
        data.get(0).setMetroStepsList(metroSteps);
        System.out.println(data);

        return  ResultBean.success(data);
    }
}
