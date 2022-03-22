package com.belong.smart.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.belong.smart.entity.po.MetroSteps;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MetroDetialBean {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "路线名称")
    private String name;

    @ApiModelProperty(value = "始发站")
    private String first;

    @ApiModelProperty(value = "终点站")
    private String end;

    @ApiModelProperty(value = "首班时间")
    private String startTime;

    @ApiModelProperty(value = "末班时间")
    private String endTime;

    @ApiModelProperty(value = "城市id")
    private Integer cityId;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private List<MetroSteps> metroStepsList;
}
