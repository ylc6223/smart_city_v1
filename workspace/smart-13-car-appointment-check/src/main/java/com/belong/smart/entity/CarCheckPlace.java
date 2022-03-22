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
 * 检车地址
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CarCheckPlace对象", description="检车地址")
public class CarCheckPlace implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "检修公司")
    private String placeName;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "电话")
    private String phone;


}
