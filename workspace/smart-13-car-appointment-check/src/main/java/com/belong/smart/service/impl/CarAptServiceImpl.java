package com.belong.smart.service.impl;

import com.belong.smart.entity.CarApt;
import com.belong.smart.entity.Cars;
import com.belong.smart.mapper.CarAptMapper;
import com.belong.smart.service.CarAptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预约表 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Service
public class CarAptServiceImpl extends ServiceImpl<CarAptMapper, CarApt> implements CarAptService {
    @Resource
    CarAptMapper carAptMapper;

    @Override
    public List<Map<String, Object>> getAptList(int userId) {
        return carAptMapper.getAptList(userId);
    }

    @Override
    public int updateCars(Cars cars) {
        return carAptMapper.updateCars(cars);
    }
}
