package com.belong.smart.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 电费详情
 * </p>
 *
 * @author belong
 * @since 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="LiveElectricityDetails对象", description="电费详情")
public class LiveElectricityDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "收费金额")
    private String electricityMoney;

    @ApiModelProperty(value = "收费单位")
    private String chargeUnit;

    @ApiModelProperty(value = "户号id")
    private Integer doorId;

    @ApiModelProperty(value = "生活缴费分类id")
    private String classifyId;


}
