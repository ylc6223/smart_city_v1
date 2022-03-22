package com.belong.smart.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 投简历历史	
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="JobDeliver对象", description="投简历历史	")
public class JobDeliver implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "岗位名称")
    private String postName;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "薪资")
    private String money;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "投递时间")
    private Date satrTime;


}
