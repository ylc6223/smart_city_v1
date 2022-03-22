package com.belong.smart.service;

import com.belong.smart.entity.RotationChart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 轮播图 服务类
 * </p>
 *
 * @author belong
 * @since 2022-03-16
 */
public interface RotationChartService extends IService<RotationChart> {
    List<String> selectUrl();

}
