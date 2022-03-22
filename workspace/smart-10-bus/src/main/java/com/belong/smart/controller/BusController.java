package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.entity.po.BusLines;
import com.belong.smart.entity.po.BusOrders;
import com.belong.smart.service.impl.BusLinesServiceImpl;
import com.belong.smart.service.impl.BusOrdersServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 巴士路线表 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Api(tags = "10、智慧巴士")
@RestController
@RequestMapping("/10_bus")
public class BusController {
    @Autowired
    BusLinesServiceImpl busLinesService;
    @Autowired
    BusOrdersServiceImpl busOrdersService;

    @ApiOperation("10.1 查询巴士路线")
    @GetMapping("/userinfo/lines/list")
    public ResultBean getLines() {
        return ResultBean.success(busLinesService.list());
    }

    @ApiOperation("10.2 根据路线编号查询路线基本信息 ")
    @GetMapping("/userinfo/lines/{id}")
    public ResultBean getLinesById(@PathVariable int id) {
        QueryWrapper<BusLines> wrapper = new QueryWrapper<BusLines>().eq("id", id);
        return ResultBean.success(busLinesService.getOne(wrapper));
    }


    @ApiOperation("10.3 根据路线编号查询站点信息  ")
    @GetMapping("/userinfo/busStop/list")
    public ResultBean getStepInfo(@RequestParam int lineId) {
        return ResultBean.success(busLinesService.getStepInfo(lineId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("10.4 新增巴士订单 *需要token")
    @PostMapping("/userinfo/busOrders")
    public ResultBean addBusOrder(@RequestBody BusOrders busOrders) {
        boolean b = busOrdersService.save(busOrders);
        if (b) {
            return ResultBean.success("新增巴士订单成功");
        }
        return ResultBean.fail("新增巴士订单失败");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", required = true)
    })
    @ApiOperation("10.5 查询巴士车订单列表  *需要token")
    @GetMapping("/userinfo/busOrders/list")
    public ResultBean getBusOrder(@RequestParam int userId) {
        QueryWrapper<BusOrders> wrapper = new QueryWrapper<BusOrders>().eq("user_id", userId);
        return ResultBean.success(busOrdersService.list(wrapper));
    }
}
