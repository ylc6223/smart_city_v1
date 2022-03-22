package com.belong.smart.service.impl;

import com.belong.smart.entity.AllService;
import com.belong.smart.mapper.AllServiceMapper_3;
import com.belong.smart.service.AllServiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 全部服务表 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Service
public class AllServiceServiceImpl_3 extends ServiceImpl<AllServiceMapper_3, AllService> implements AllServiceService {
    @Resource
    AllServiceMapper_3 mapper;

    @Override
    public List<AllService> findAll() {
        return mapper.findAll();
    }
}
