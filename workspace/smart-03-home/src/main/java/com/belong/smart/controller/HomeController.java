package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.belong.smart.entity.*;
import com.belong.smart.service.impl.AllServiceServiceImpl;
import com.belong.smart.service.impl.PressServiceImpl;
import com.belong.smart.service.impl.RotationChartServiceImpl;
import com.belong.smart.service.impl.SysDictDataServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 轮播图 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-16
 */
@Api(tags = "03、主页面")
@RestController
public class HomeController {
    @Autowired
    RotationChartServiceImpl rotationChartService;
    @Autowired
    AllServiceServiceImpl allService;
    @Autowired
    PressServiceImpl pressService;
    @Autowired
    SysDictDataServiceImpl newCateService;

    @ApiOperation("3.1 主页面轮播图列表")
    @GetMapping("/userinfo/rotation/list")
    public ResultBean HomeBanner(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam int type) {
        QueryWrapper<RotationChart> wrapper = new QueryWrapper<RotationChart>().eq("type", type);
        Page<RotationChart> page = rotationChartService.page(new Page<>(pageNum, pageSize), wrapper);
        return ResultBean.success(page);
    }

    @ApiOperation("3.2 查询推荐服务")
    @GetMapping("/service/service/list")
    public ResultBean AllService() {
        return ResultBean.success("200", "查询成功", allService.list());
    }

    @ApiOperation("3.3 查询专题新闻列表")
    @GetMapping("/press/press/list/{category}")
    public ResultBean getNewList(@PathVariable int category) {
        QueryWrapper<Press> wrapper = new QueryWrapper<Press>().eq("press_category", 48);
        return ResultBean.success("200", "查询成功", pressService.list(wrapper));
    }

    @ApiOperation("3.4 查询新闻分类")
    @GetMapping("/system/dict/data/type/press_category")
    public ResultBean getNewCate() {
        QueryWrapper<SysDictData> wrapper = new QueryWrapper<SysDictData>().eq("dict_type", "press_category");
        return ResultBean.success("200", "查询成功", newCateService.list(wrapper));
    }

    @ApiOperation("3.5 查询所属分类下的新闻列表")
    @GetMapping("/list5")
    public ResultBean getNewCateByCate(@RequestParam int pressCategory) {
        QueryWrapper<Press> wrapper = new QueryWrapper<Press>().eq("press_category", pressCategory);
        return ResultBean.success("200", "查询成功", pressService.list(wrapper));
    }

}
