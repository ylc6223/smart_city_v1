package com.belong.smart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 全部服务表
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AllService implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务简介
     */
    private String serviceDesc;

    /**
     * 服务类别
     */
    private String serviceType;

    /**
     * 服务图片
     */
    private String imgUrl;

    /**
     * pid
     */
    private Integer pid;

    /**
     * 链接
     */
    private String link;

    /**
     * 是否推荐 1、是  0、否
     */
    private Boolean isRecommend;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
