package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.VehicleMoveCar;
import com.belong.smart.service.impl.VehicleMoveCarServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Api(tags = "16、堵车移车")
@RestController
@RequestMapping("/16_move_car")
public class VehicleMoveCarController {
    @Autowired
    VehicleMoveCarServiceImpl vehicleMoveCarService;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("16.2 查询挪车记录 *需要token")
    @GetMapping("/userinfo/caraction")
    public ResultBean getMoveCarHistory(@RequestParam int userId) {
        QueryWrapper<VehicleMoveCar> wrapper = new QueryWrapper<VehicleMoveCar>()
                .eq("user_id", userId);
        return ResultBean.success(vehicleMoveCarService.list(wrapper));
    }
}
