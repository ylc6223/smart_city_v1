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
 * 
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="HouseSource对象", description="")
public class HouseSource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "房源名称")
    private String sourceName;

    @ApiModelProperty(value = "房源地址")
    private String address;

    @ApiModelProperty(value = "面积")
    private Integer areaSize;

    @ApiModelProperty(value = "联系电话")
    private String tel;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "房子类型")
    private String houseType;

    @ApiModelProperty(value = "图片多个图片用逗号隔开")
    private String pic;

    @ApiModelProperty(value = "详情描述")
    private String desc;


}
