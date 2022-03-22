package com.belong.smart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 违章查询
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Illegal对象", description="违章查询")
public class Illegal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车牌")
    private String licencePlate;

    @ApiModelProperty(value = " 处理状态 1 已处理  0未处理")
    private String disposeState;

    @ApiModelProperty(value = "违章时间")
    private LocalDateTime badTime;

    @ApiModelProperty(value = "金额")
    private String money;

    @ApiModelProperty(value = "扣分")
    private String deductMarks;

    @ApiModelProperty(value = "违章地点")
    @TableField("Illegal_sites")
    private String illegalSites;

    @ApiModelProperty(value = "通知书号")
    private String noticeNo;

    @ApiModelProperty(value = "发动机号")
    private String engineNumber;

    @ApiModelProperty(value = "违章行为")
    private String trafficOffence;

    @ApiModelProperty(value = "号牌种类  ")
    private String catType;


}
