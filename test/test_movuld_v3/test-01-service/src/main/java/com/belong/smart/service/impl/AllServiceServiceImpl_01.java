package com.belong.smart.service.impl;

import com.belong.smart.entity.AllService;
import com.belong.smart.mapper.AllServiceMapper;
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
public class AllServiceServiceImpl_01 extends ServiceImpl<AllServiceMapper, AllService> implements AllServiceService {
    @Resource
    AllServiceMapper mapper;

    @Override
    public List<AllService> findAll() {
        return mapper.findAll();
    }
}
