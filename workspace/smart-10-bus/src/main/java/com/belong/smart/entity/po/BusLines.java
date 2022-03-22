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
 * 巴士路线表
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BusLines对象", description="巴士路线表")
public class BusLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "路线名称")
    private String name;

    @ApiModelProperty(value = "起始点")
    private String first;

    @ApiModelProperty(value = "终点")
    private String end;

    @ApiModelProperty(value = "首发时间")
    private String startTime;

    @ApiModelProperty(value = "末班时间")
    private String endTime;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "里程")
    private String mileage;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
