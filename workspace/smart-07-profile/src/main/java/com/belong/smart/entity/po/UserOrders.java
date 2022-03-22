package com.belong.smart.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户订单表
 * </p>
 *
 * @author belong
 * @since 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserOrders对象", description="用户订单表")
public class UserOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderNum;

    @ApiModelProperty(value = "订单类别")
    private Boolean orderType;

    @ApiModelProperty(value = "logo路径")
    private String logoUrl;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "状态")
    private Boolean orderStatus;

    @ApiModelProperty(value = "路线")
    private String path;

    @ApiModelProperty(value = "始发地点")
    private String start;

    @ApiModelProperty(value = "终到")
    private String end;

    @ApiModelProperty(value = "金额")
    private BigDecimal price;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户电话")
    private String userTel;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
