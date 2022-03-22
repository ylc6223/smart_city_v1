package com.belong.blog.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.blog.common.Result;
import com.belong.blog.common.dto.LoginDto;
import com.belong.blog.entity.User;
import com.belong.blog.service.impl.UserServiceImpl;
import com.belong.blog.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;

@RestController
public class AccountController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto) {
        // 1. 判断用户名密码是否为空，jsr303校验已经帮我们做好了
        // 2. 查询数据库是否有该用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", loginDto.getUsername());
        User user = userService.getOne(wrapper);
        Assert.notNull(user, "用户不存在");

        // 3. 校验密码是否与数据库匹配的上
        String password = SecureUtil.md5(loginDto.getPassword());
        if (!user.getPassword().equals(password)) {
            return Result.fail("密码错误");
        }

        // 4. 生成token，与用户信息一起返回给前端
        String token = JwtUtils.createToken(user.getUsername());

        return Result.success(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .put("token", token)
                .map()
        );

    }
}
