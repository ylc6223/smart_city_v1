package com.belong.smart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.belong.smart.entity.AllService;
import com.belong.smart.mapper.ServiceMapper;
import com.belong.smart.service.ServiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, AllService> implements ServiceService {
    @Resource
    ServiceMapper mapper;

    @Override
    public List<Map<String, Object>> findOneService() {
        return mapper.findOneService();
    }
}
