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
 * 生活缴费户主信息表
 * </p>
 *
 * @author belong
 * @since 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="LiveHouseholder对象", description="生活缴费户主信息表")
public class LiveHouseholder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "户号")
    private Integer doorNo;

    @ApiModelProperty(value = "户主")
    private String ownerName;

    @ApiModelProperty(value = "余额")
    private String balance;

    @ApiModelProperty(value = "用户id")
    private Integer userId;


}
