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
 * 停车场表
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ParkLot对象", description="停车场表")
public class ParkLot implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "停车场名称")
    private String parkName;

    @ApiModelProperty(value = "空位个数")
    private String vacancy;

    @ApiModelProperty(value = "封顶价格/天")
    private String priceCaps;

    @ApiModelProperty(value = "图片路径")
    private String imgUrl;

    @ApiModelProperty(value = "收费")
    private String rates;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "距离")
    private String distance;

    @ApiModelProperty(value = "总停车位")
    private String allPark;


}
