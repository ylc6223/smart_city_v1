package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.belong.smart.entity.CarApt;
import com.belong.smart.entity.CarCheckPlace;
import com.belong.smart.entity.Cars;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.service.impl.CarAptServiceImpl;
import com.belong.smart.service.impl.CarCheckPlaceServiceImpl;
import com.belong.smart.service.impl.CarNoticeServiceImpl;
import com.belong.smart.service.impl.CarsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 检车地址 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Api(tags = "13、预约检车")
@RestController
@RequestMapping("/13_car_check")
public class CarCheckController {
    @Autowired
    CarNoticeServiceImpl carNoticeService;
    @Autowired
    CarCheckPlaceServiceImpl carCheckPlaceService;
    @Autowired
    CarAptServiceImpl carAptService;
    @Autowired
    CarsServiceImpl carsService;

    @ApiOperation("13.1 查询预约须知")
    @GetMapping("/userinfo/carNotice/grt")
    public ResultBean getNotice() {
        return ResultBean.success(carNoticeService.getOne(null));
    }

    @ApiOperation("13.2 查询所有检车地点")
    @GetMapping("/userinfo/place/list")
    public ResultBean getPlaceList() {
        return ResultBean.success(carCheckPlaceService.list());
    }

    @ApiOperation("13.3 查询检车点详情")
    @GetMapping("/userinfo/place/{id}")
    public ResultBean getPlaceList(@PathVariable int id) {
        QueryWrapper<CarCheckPlace> wrapper = new QueryWrapper<CarCheckPlace>().eq("id", id);
        return ResultBean.success(carCheckPlaceService.getOne(wrapper));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("13.4 预约检车 *需要token")
    @PostMapping("/userinfo/apt")
    public ResultBean aptCar(@RequestBody CarApt carApt) {
        boolean b = carAptService.save(carApt);
        if (b) {
            return ResultBean.success("预约成功");
        }
        return ResultBean.fail("预约失败");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("13.5 查询预约检车订单 *需要token")
    @GetMapping("/userinfo/apt/list")
    public ResultBean getCarAptList(@RequestParam int userId) {
        return ResultBean.success(carAptService.getAptList(userId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("13.6 查询我的车辆 *需要token")
    @GetMapping("/userinfo/cars/list")
    public ResultBean getMyCarList(@RequestParam int userId) {
        QueryWrapper<Cars> wrapper = new QueryWrapper<Cars>().eq("user_id", userId);
        return ResultBean.success(carsService.list(wrapper));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("13.7 新增车辆  *需要token")
    @PostMapping("/userinfo/cars")
    public ResultBean addCarList(@RequestBody Cars cars) {
        boolean b = carsService.save(cars);
        if (b) {
            return ResultBean.success("新增车辆成功");
        }
        return ResultBean.success("新增车辆失败");
    }


    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("13.8 修改车辆  *需要token")
    @PutMapping("/userinfo/cars")
    public ResultBean updateCar(@RequestBody Cars cars) {
        int i = carAptService.updateCars(cars);
        if (i > 0) {
            return ResultBean.success("修改车辆成功");
        }
        return ResultBean.success("修改车辆失败");
    }


    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("13.9 删除车辆信息  *需要token")
    @DeleteMapping("/userinfo/cars/{id}")
    public ResultBean updateCar(@PathVariable int id) {
        boolean b = carsService.removeById(id);
        if (b) {
            return ResultBean.success("删除车辆成功");
        }
        return ResultBean.success("删除车辆失败");
    }
}
