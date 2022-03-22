package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.belong.smart.entity.PressComment;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.dto.AddComment;
import com.belong.smart.service.impl.PressCommentServiceImpl;
import com.belong.smart.service.impl.PressServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 新闻表 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-17
 */
@Api(tags = "05、新闻")
@RestController
@RequestMapping("/05_press")
public class PressController {
    @Autowired
    PressServiceImpl pressService;
    @Autowired
    PressCommentServiceImpl pressCommentService;

    @ApiOperation("5.1 查询新闻列表")
    @GetMapping("/list1")
    public ResultBean getNewList(@RequestParam int pageNum, @RequestParam int pageSize) {
        return ResultBean.success(pressService.page(new Page<>(pageNum, pageSize)));
    }


    @ApiOperation("5.2 查询评论列表")
    @GetMapping("/list2")
    public ResultBean getCommentList(@RequestParam int pressId) {
        List<Map<String, Object>> maps = pressCommentService.selectCommentList(pressId);
        return ResultBean.success(maps);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("5.3 新增评论  * 需要token")
    @PostMapping("/list3")
    public ResultBean addComment(@RequestBody PressComment pressComment) {
        boolean b = pressCommentService.save(pressComment);
        if (b) {
            return ResultBean.success("");
        }
        return ResultBean.fail("新增失败");
    }







}
