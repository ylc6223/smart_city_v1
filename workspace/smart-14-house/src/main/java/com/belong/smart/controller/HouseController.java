package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.smart.entity.HouseSource;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.service.impl.HouseSourceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Api(tags = "14、找房子")
@RestController
@RequestMapping("/14_house")
public class HouseController {
    @Autowired
    HouseSourceServiceImpl houseSourceService;

    @ApiOperation("14.1 查询房源列表")
    @GetMapping("/userinfo/housing/list")
    public ResultBean getHouseList() {
        return ResultBean.success(houseSourceService.getHouseList());
    }

    @ApiOperation("14.2 查询房源详情")
    @GetMapping("/userinfo/housing/{id}")
    public ResultBean getHouseDetial(@PathVariable int id) {
        return  ResultBean.success(houseSourceService.getHouseDetial(id));
    }

    @ApiOperation("14.3 根据房源名称模糊查询")
    @GetMapping("/userinfo/housing/list/byName")
    public ResultBean getHouseListByName(@RequestParam String sourceName) {
        return  ResultBean.success(houseSourceService.getHouseByName(sourceName));
    }

    @ApiOperation("14.4 根据分类查询房源 ")
    @GetMapping("/userinfo/housing/list/byType")
    public ResultBean getHouseListByTYpe(@RequestParam int houseType) {
        return  ResultBean.success(houseSourceService.getHouseByType(houseType));
    }




}
