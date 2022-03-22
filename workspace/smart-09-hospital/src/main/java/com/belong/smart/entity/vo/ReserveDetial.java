package com.belong.smart.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class ReserveDetial {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "预约单号")
    private String orderNo;

    @ApiModelProperty(value = "就诊人姓名")
    private String patientName;

    @ApiModelProperty(value = "科室id")
    private Integer divisionId;

    @ApiModelProperty(value = "门诊类型id")
    private String typesId;

    @ApiModelProperty(value = "金额")
    private String moeny;

    @ApiModelProperty(value = "预约时间")
    private LocalDateTime startime;

    @ApiModelProperty(value = "订单状态")
    private String reservedStatus;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

}
