package com.belong.smart.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 全部服务表
 * </p>
 *
 * @author belong
 * @since 2022-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AllService对象", description="全部服务表")
public class AllService implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "服务名称")
    private String serviceName;

    @ApiModelProperty(value = "服务简介")
    private String serviceDesc;

    @ApiModelProperty(value = "服务类别")
    private String serviceType;

    @ApiModelProperty(value = "服务图片")
    private String imgUrl;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "链接")
    private String link;

    @ApiModelProperty(value = "是否推荐 1、是  0、否")
    private Boolean isRecommend;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
