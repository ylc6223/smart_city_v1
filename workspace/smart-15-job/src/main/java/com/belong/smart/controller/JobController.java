package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.smart.entity.JobDeliver;
import com.belong.smart.entity.JobResume;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.service.impl.JobDeliverServiceImpl;
import com.belong.smart.service.impl.JobResumeServiceImpl;
import com.belong.smart.service.impl.JobServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "15、找工作")
@RestController
@RequestMapping("/15_job")
public class JobController {
    @Autowired
    JobServiceImpl jobService;
    @Autowired
    JobDeliverServiceImpl jobDeliverService;
    @Autowired
    JobResumeServiceImpl jobResumeService;

    @ApiOperation("15.1 查询热门职位")
    @GetMapping("/userinfo/profession/list")
    public ResultBean getHotJob() {
        return ResultBean.success(jobService.getHotList());
    }

    @ApiOperation("15.2 查询求职列表")
    @GetMapping("/userinfo/post/list")
    public ResultBean getPostList() {
        return ResultBean.success(jobService.getPostList());
    }

    @ApiOperation("15.3 根据热门职位编号查询职位信息")
    @GetMapping("/userinfo/post/list/byId")
    public ResultBean getPostListById(@RequestParam int professionId) {
        return ResultBean.success(jobService.getPostListById(professionId));
    }

    @ApiOperation("15.4 根据职位名称搜索职位")
    @GetMapping("/userinfo/post/list/byName")
    public ResultBean getPostListByName(@RequestParam String name) {
        return ResultBean.success(jobService.getPostListByName(name));
    }

    @ApiOperation("15.5 查询职位详情")
    @GetMapping("/userinfo/post/{id}")
    public ResultBean getPostDetial(@PathVariable int id) {
        return ResultBean.success(jobService.getPostDetial(id).get(0));
    }

    @ApiOperation("15.6 根据公司编号查询公司信息")
    @GetMapping("/userinfo/company/{id}")
    public ResultBean getCompanyId(@PathVariable int id) {
        return ResultBean.success(jobService.getCompanyById(id).get(0));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("15.7 投简历  *需要token")
    @PostMapping("/userinfo/deliver")
    public ResultBean addDeliver(@RequestBody JobDeliver jobDeliver) {
        boolean b = jobDeliverService.save(jobDeliver);
        if (b) {
            return ResultBean.success("投递成功");
        }
        return ResultBean.fail("投递失败");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("15.8 查询投简历历史  *需要token")
    @GetMapping("/userinfo/deliver/list")
    public ResultBean getDeliverList() {
        return ResultBean.success(jobDeliverService.list());
    }


    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("15.10 查询用户求职信息  *需要token")
    @GetMapping("/userinfo/resume/{id}")
    public ResultBean getDeliverByUser(@PathVariable int id) {
        QueryWrapper<JobResume> wrapper = new QueryWrapper<JobResume>()
                .eq("user_id", id);
        return ResultBean.success(jobResumeService.getOne(wrapper));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("15.11 修改用户求职信息  *需要token")
    @PutMapping("/userinfo/resume")
    public ResultBean updateResumerByUser(@RequestBody JobResume jobResume) {
        int i = jobService.updateResume(jobResume);
        if (i == 0) {
            return ResultBean.fail("修改求职信息失败");
        }
        return ResultBean.success("修改求职信息成功");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("15.12 新增用户求职信息  *需要token")
    @PostMapping("/userinfo/resume")
    public ResultBean addResume(@RequestBody JobResume jobResume) {
        boolean b = jobResumeService.save(jobResume);
        if (!b) {
            return ResultBean.fail("新增求职信息失败");
        }
        return ResultBean.success("新增求职信息成功");
    }


}
