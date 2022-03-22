package com.belong.smart.controller;

import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.po.LiveHouseholder;
import com.belong.smart.service.impl.LiveServiceImlp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "08、生活缴费")
@RequestMapping("/08_live")
@RestController
public class LiveController {
    @Autowired
    LiveServiceImlp liveService;

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("8.1 查询缴费类型列表 * 需要token")
    @GetMapping("/userinfo/feeslist/list")
    public ResultBean getTypeList(@RequestParam int userId, @RequestParam int classifyId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("classifyId", classifyId);
        return ResultBean.success(liveService.getTypeList(map));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("8.2 根据用户id查询缴费类型列表  * 需要token")
    @GetMapping("/userinfo/householder/{userId}")
    public ResultBean getPayInfo(@PathVariable int userId) {
        return ResultBean.success(liveService.getPayInfo(userId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("8.3 根据户号和用户id查询缴费详情  * 需要token")
    @GetMapping("/userinfo/electricity/list")
    public ResultBean getPayDetial(@RequestParam int userId, @RequestParam int doorNo) {
        return ResultBean.success(liveService.getPayDetial(userId, doorNo));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("8.4 根据户号缴费   * 需要token")
    @PutMapping("/userinfo/householder")
    public ResultBean payByDoor(@RequestBody LiveHouseholder liveHouseholder) {
        int i = liveService.payByDoor(liveHouseholder);
        if (i == 0) {
            return ResultBean.fail("缴费失败");
        } else {
            return ResultBean.success("");
        }
    }

}
