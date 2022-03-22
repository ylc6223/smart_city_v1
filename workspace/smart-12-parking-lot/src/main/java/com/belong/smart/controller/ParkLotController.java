package com.belong.smart.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.belong.smart.entity.ParkLot;
import com.belong.smart.entity.ParkRecord;
import com.belong.smart.entity.ResultBean;
import com.belong.smart.service.impl.ParkLotServiceImpl;
import com.belong.smart.service.impl.ParkRecordServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 停车场表 前端控制器
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Api(tags = "12、停车场查询")
@RestController
@RequestMapping("/12_park_lot")
public class ParkLotController {
    @Autowired
    ParkLotServiceImpl parkLotService;
    @Autowired
    ParkRecordServiceImpl parkRecordService;

    @ApiOperation("12.1 查询停车场列表")
    @GetMapping("/userinfo/parklot/list")
    public ResultBean getParkingList() {
        return ResultBean.success(parkLotService.list());
    }

    @ApiOperation("12.2 查询停车场详情")
    @GetMapping("/userinfo/parklot/{id}")
    public ResultBean getParkingDetial(@PathVariable int id) {
        QueryWrapper<ParkLot> wrapper = new QueryWrapper<ParkLot>().eq("id", id);
        return ResultBean.success(parkLotService.getOne(wrapper));
    }

    @ApiOperation("12.3 查询停车记录")
    @GetMapping("/userinfo/parkrecord/list")
    public ResultBean getParkingRecord(@RequestParam String plateNumber) {
        QueryWrapper<ParkRecord> wrapper = new QueryWrapper<ParkRecord>()
                .eq("plate_number", plateNumber);
        return ResultBean.success(parkRecordService.list(wrapper));
    }

    @ApiOperation("12.4 根据时间查询停车记录")
    @GetMapping("/userinfo/parkrecord/list/byTime")
    public ResultBean getParkingRecordByTime(@RequestParam String entryTime, @RequestParam String plateNumber, @RequestParam String outTime) {
        QueryWrapper<ParkRecord> wrapper = new QueryWrapper<ParkRecord>()
                .eq("plate_number", plateNumber)
                .ge("entry_time", entryTime)
                .le("out_time", outTime);
        return ResultBean.success(parkRecordService.list(wrapper));
    }
}
