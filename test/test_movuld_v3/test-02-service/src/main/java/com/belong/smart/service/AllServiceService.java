package com.belong.smart.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.belong.smart.entity.AllService;

import java.util.List;

/**
 * <p>
 * 全部服务表 服务类
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
public interface AllServiceService extends IService<AllService> {
    List<AllService> findAll();

}
