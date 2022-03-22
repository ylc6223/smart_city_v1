package com.belong.smart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车辆信息
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Cars对象", description="车辆信息")
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车牌")
    private String plateNum;

    @ApiModelProperty(value = "车架号")
    private String mainNum;

    @ApiModelProperty(value = "汽车型号")
    private String carType;

    @ApiModelProperty(value = "公里数")
    private String mileage;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "关联的用户编号")
    private Integer userId;


}
