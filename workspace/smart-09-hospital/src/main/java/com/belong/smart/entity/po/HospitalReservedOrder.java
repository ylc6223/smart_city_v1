package com.belong.smart.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 预约单
 * </p>
 *
 * @author belong
 * @since 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="HospitalReservedOrder对象", description="预约单")
public class HospitalReservedOrder implements Serializable {

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
    private Date startime;

    @ApiModelProperty(value = "订单状态")
    private String reservedStatus;

    @ApiModelProperty(value = "用户id")
    private Integer userId;


}
