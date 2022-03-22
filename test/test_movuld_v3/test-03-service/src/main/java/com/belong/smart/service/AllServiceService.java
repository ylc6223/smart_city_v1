package com.belong.smart.service;

import com.belong.smart.entity.AllService;
import com.baomidou.mybatisplus.extension.service.IService;

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
