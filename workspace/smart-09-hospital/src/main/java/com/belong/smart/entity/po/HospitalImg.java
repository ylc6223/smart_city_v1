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
 * 医院轮播图
 * </p>
 *
 * @author belong
 * @since 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="HospitalImg对象", description="医院轮播图")
public class HospitalImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String imgUrl;

    private Integer hospitalId;


}
