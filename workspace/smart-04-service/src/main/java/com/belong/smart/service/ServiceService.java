package com.belong.smart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.belong.smart.entity.AllService;

import java.util.List;
import java.util.Map;

public interface ServiceService extends IService<AllService> {
    List<Map<String, Object>> findOneService();
}
