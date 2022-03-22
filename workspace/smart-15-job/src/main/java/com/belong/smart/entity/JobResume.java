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
 * 简历
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="JobResume对象", description="简历")
public class JobResume implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "最高学历")
    private String mostEducation;

    @ApiModelProperty(value = "教育经历")
    private String education;

    @ApiModelProperty(value = "现居住地")
    private String address;

    @ApiModelProperty(value = "工作经历")
    private String experience;

    @ApiModelProperty(value = "个人简介")
    private String individualResume;

    @ApiModelProperty(value = "期望薪资")
    private String money;

    @ApiModelProperty(value = "期望职位id")
    private String positionId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "简历附件")
    private String files;


}
