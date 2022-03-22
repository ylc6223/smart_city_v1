package com.belong.smart.service.impl;

import com.belong.smart.entity.Cars;
import com.belong.smart.mapper.CarsMapper;
import com.belong.smart.service.CarsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆信息 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Service
public class CarsServiceImpl extends ServiceImpl<CarsMapper, Cars> implements CarsService {

}
