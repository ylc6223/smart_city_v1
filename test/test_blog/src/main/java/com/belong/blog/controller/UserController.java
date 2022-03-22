package com.belong.blog.controller;


import com.belong.blog.common.Result;
import com.belong.blog.entity.User;
import com.belong.blog.service.impl.UserServiceImpl;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/getAll")
    public Result getAllUser() {
        return Result.success("200", "查询成功", userService.list());
    }

    @PostMapping("/save_user")
    public Result saveUser(@Validated @RequestBody User user) {
        return Result.success(user);
    }
}
