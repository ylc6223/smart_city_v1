package com.belong.smart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 预约表
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CarApt对象", description="预约表")
public class CarApt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "车辆编号")
    private String carId;

    @ApiModelProperty(value = "预约时间")
    private String aptTime;

    @ApiModelProperty(value = "预约地址id")
    private String addressId;

    @ApiModelProperty(value = "1成功 0失败")
    private String success;


}
