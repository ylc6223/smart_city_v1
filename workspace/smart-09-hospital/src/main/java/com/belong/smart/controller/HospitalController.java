package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.po.HospitalPatient;
import com.belong.smart.entity.po.HospitalReservedOrder;
import com.belong.smart.service.HospitalService;
import com.belong.smart.service.impl.HospitalPatientServiceImpl;
import com.belong.smart.service.impl.HospitalReservedOrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.Map;

/**
 * <p>
 * 医院轮播图 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-20
 */
@Api(tags = "09、门诊预约")
@RestController
@RequestMapping("/09_hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;
    @Autowired
    HospitalPatientServiceImpl hospitalPatientService;
    @Autowired
    HospitalReservedOrderServiceImpl reservedOrderService;

    @ApiOperation("9.1 医院详情轮播图")
    @GetMapping("/userinfo/img/list")
    public ResultBean getBannerList(@RequestParam int hospitalId) {
        return ResultBean.success(hospitalService.getImgList(hospitalId));
    }

    @ApiOperation("9.2 根据医院编号查询医院信息 ")
    @GetMapping("/userinfo/registration/{id}")
    public ResultBean getHospitalInfo(@PathVariable int id) {
        return ResultBean.success(hospitalService.getHospitaInfo(id));
    }

    @ApiOperation("9.3 查询医院列表")
    @GetMapping("/userinfo/registration/list")
    public ResultBean getHospitalList() {
        return ResultBean.success(hospitalService.getHospitaList());
    }

    @ApiOperation("9.4 根据名称模糊搜索医院信息")
    @GetMapping("/userinfo/registration/list/search")
    public ResultBean searchHospital(@RequestParam String hospitalName) {
        return ResultBean.success(hospitalService.searchHospital(hospitalName));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("9.5 根据用户id查询当前用户下的就诊人卡片 *需要token ")
    @GetMapping("/userinfo/patient/list")
    public ResultBean getCardList(@RequestParam int userId) {
        QueryWrapper<HospitalPatient> wrapper = new QueryWrapper<HospitalPatient>().eq("user_id", userId);
        return ResultBean.success(hospitalPatientService.list(wrapper));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("9.6 新增就诊人卡片 *需要token")
    @PostMapping("/userinfo/patient")
    public ResultBean addCard(@RequestBody HospitalPatient hospitalPatient) {
        boolean b = hospitalPatientService.save(hospitalPatient);
        if (b) {
            return ResultBean.success("新增成功");
        }
        return ResultBean.fail("新增失败");
    }


    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("9.7 修改就诊人卡片 *需要token")
    @PutMapping("/userinfo/patient")
    public ResultBean updateCard(@RequestBody HospitalPatient hospitalPatient) {
        boolean b = hospitalPatientService.updateById(hospitalPatient);
        if (b) {
            return ResultBean.success("修改成功");
        }
        return ResultBean.fail("修改失败");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("9.8 查询专家与普通下的科室分类 *需要token")
    @GetMapping("/userinfo/types/list")
    public ResultBean getType(@RequestParam int did) {
        return ResultBean.success(hospitalService.getType(did));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("9.9 根据用户id查询用户预约列表 *需要token")
    @GetMapping("/userinfo/order/list")
    public ResultBean getReserveList(@RequestParam int userId) {
        return ResultBean.success(hospitalService.getReserveList(userId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("9.10 根据ID查询预约详情 *需要token")
    @GetMapping("/userinfo/order/{id}")
    public ResultBean getReserveDetail(@PathVariable int id) {
        Map<String, Object> map = hospitalService.getReserveDetail(id).get(0);
        return ResultBean.success(map);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("9.11 生成预约单 *需要token")
    @PostMapping("/userinfo/order")
    public ResultBean addReserveOrder(@RequestBody HospitalReservedOrder hospitalReservedOrder) {
        boolean b = reservedOrderService.save(hospitalReservedOrder);
        if (b) {
            return ResultBean.success("预约单生成成功");
        } else {
            return ResultBean.success("预约单生成失败");
        }
    }

}
