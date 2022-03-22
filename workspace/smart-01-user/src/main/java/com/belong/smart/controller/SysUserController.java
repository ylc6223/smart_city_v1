package com.belong.smart.controller;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.SysUser;
import com.belong.smart.entity.dto.LoginDto;
import com.belong.smart.service.SysUserService;
import com.belong.smart.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-16
 */
@Api(tags = "01、登录注册")
@RestController
public class SysUserController {
    @Autowired
    SysUserService userService;

    // 登录
    @ApiOperation("1.1 登录")
    @PostMapping("/login")
    public ResultBean login(@Validated @RequestBody LoginDto loginDto) {
        // 1. 判断用户名密码是否为空，JSR303校验已经帮我们做好了
        // 2. 查询数据库是否有该用户
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", loginDto.getUsername());
        SysUser user = userService.getOne(wrapper);
        Assert.notNull(user, "用户不存在");

        // 3. 校验密码是否与数据库匹配匹对
        String password = loginDto.getPassword();
        if (!password.equals(user.getPassword())) {
            return ResultBean.fail("密码错误");
        }

        // 4. 生成token返回给前端
        String token = JwtUtils.createToken(loginDto.getUsername());
        return  ResultBean.success(token);
    }

    // 注册
    @ApiOperation("1.2 注册")
    @PostMapping("/system/user/register")
    public ResultBean register(@RequestBody SysUser user) {
        // 1. 判断用户名是否在数据库中已存在
        QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>().eq("user_name", user.getUserName());
        int count = userService.count(wrapper);
        if (count > 0) {
            return ResultBean.fail("用户名已存在，请重新注册");
        }
        // 2. 存入数据库
        boolean b = userService.save(user);
        if (b) {
            return ResultBean.success("注册成功");
        }
        return ResultBean.fail("注册失败");
    }

}
