package com.belong.smart.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.dto.AddFeedBack;
import com.belong.smart.entity.dto.PasswrodDto;
import com.belong.smart.entity.dto.UserBean;
import com.belong.smart.entity.po.SysUser;
import com.belong.smart.entity.po.UserOrders;
import com.belong.smart.entity.vo.ProfileDetialBean;
import com.belong.smart.mapper.ProfileMapper;
import com.belong.smart.service.impl.ProfileServiceImpl;
import com.belong.smart.service.impl.UserOrdersServiceImpl;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Api(tags = "07、个人中心")
@RestController
@RequestMapping("/07_profile")
public class ProfileController {
    @Autowired
    ProfileServiceImpl profileService;
    @Autowired
    UserOrdersServiceImpl ordersService;

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("7.1 查询用户详细信息     *需要token")
    @GetMapping("/getInfo")
    public ResultBean fun1(@RequestParam int id) {
        //List<Map<String, Object>> list = mapper.getDetial2(id);

        List<ProfileDetialBean> list = profileService.getDetial(id);
        return ResultBean.success(list);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("7.2 查询个人基本信息     *需要token")
    @GetMapping("/system/user/{id}")
    public ResultBean fun2(@PathVariable int id) {
        return ResultBean.success(profileService.getUserBaseInfo(id));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("7.3 修改用户基本信息  *需要token")
    @PostMapping("/system/user/updata")
    public ResultBean UpdateUser(@Validated @RequestBody SysUser sysUser) {
        boolean b = profileService.updateById(sysUser);
        if (b) {
            return ResultBean.success(null);
        }
        return ResultBean.fail("修改失败");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("7.4 修改用户密码  *需要token")
    @PutMapping("/system/user/resetPwd")
    public ResultBean UpdateUserPasswrod(@Validated @RequestBody PasswrodDto passwrodDto) {
        // 1. 查询用户id和旧密码是否匹配成功
        QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>()
                .eq("user_id", passwrodDto.getUserId())
                .eq("password", passwrodDto.getOldPwd());
        int count = profileService.count(wrapper);
        if (count == 0) {
            return ResultBean.fail("旧密码错误，请重新填写");
        }
        // 2. 更改新密码
        SysUser user = new SysUser();
        user.setUserId(passwrodDto.getUserId());
        user.setPassword(passwrodDto.getPassword());

        boolean b = profileService.updateById(user);
        if (b) {
            return ResultBean.success(null);
        }
        return ResultBean.fail("密码更新失败");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("7.5 查询订单总列表  *需要token")
    @GetMapping("/userinfo/orders/list")
    public ResultBean getOrderList(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam int userId) {
        Page<UserOrders> page = new Page<>(pageNum, pageSize);
        QueryWrapper<UserOrders> wrapper = new QueryWrapper<UserOrders>().eq("user_id", userId);
        return ResultBean.success(ordersService.page(page, wrapper));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("7.6 查询意见反馈列表  *需要token")
    @GetMapping("/userinfo/feedback/list")
    public ResultBean getFBList(@RequestParam int userId) {
        return ResultBean.success(profileService.getFBList(userId));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("7.7 查询意见反馈详情  *需要token")
    @GetMapping("/userinfo/feedback/{id}")
    public ResultBean getFBDetial(@PathVariable int id) {
        return ResultBean.success(profileService.getFBDetial(id));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "header", name = "Authorization",
                    required = true)
    })
    @ApiOperation("7.7 新增意见反馈  *需要token")
    @PostMapping("/userinfo/feedback")
    public ResultBean getFBDetial(@RequestBody AddFeedBack addFeedBack) {
        int i = profileService.addFB(addFeedBack.getUserId(), addFeedBack.getContent());
        if (i > 0) {
            return ResultBean.success(null);
        }
        return ResultBean.success("新增失败");
    }

}
