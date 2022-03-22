package com.belong.smart.service.impl;

import com.belong.smart.entity.RotationChart;
import com.belong.smart.mapper.RotationChartMapper;
import com.belong.smart.service.RotationChartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 轮播图 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-16
 */
@Service
public class RotationChartServiceImpl extends ServiceImpl<RotationChartMapper, RotationChart> implements RotationChartService {
    @Resource
    RotationChartMapper mapper;

    @Override
    public List<String> selectUrl() {
        return mapper.selectUrl();
    }
}
