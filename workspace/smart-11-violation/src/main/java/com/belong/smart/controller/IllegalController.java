package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.smart.entity.Illegal;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.service.impl.IllegalServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 违章查询 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Api(tags = "11、违章查询")
@RestController
@RequestMapping("/11_illegal")
public class IllegalController {
    @Autowired
    IllegalServiceImpl illegalService;

    @ApiOperation("11.1 根据车牌、发动机号车型查询违章情况")
    @GetMapping("/userinfo/illegal/list")
    public ResultBean getViolationList(@RequestParam String catType, @RequestParam int engineNumber, @RequestParam String licencePlate) {
        QueryWrapper<Illegal> wrapper = new QueryWrapper<Illegal>()
                .eq("cat_type", catType)
                .eq("engine_number", engineNumber)
                .eq("licence_plate", licencePlate);
        return ResultBean.success(illegalService.list(wrapper));
    }

    @ApiOperation("11.2 根据违章编号查询违章详情")
    @GetMapping("/userinfo/illegal/{id}")
    public ResultBean getViolationList(@PathVariable int id) {
        QueryWrapper<Illegal> wrapper = new QueryWrapper<Illegal>()
                .eq("id", id);
        return ResultBean.success(illegalService.getOne(wrapper));
    }
}
