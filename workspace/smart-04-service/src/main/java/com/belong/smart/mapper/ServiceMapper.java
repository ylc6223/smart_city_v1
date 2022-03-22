package com.belong.smart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.belong.smart.entity.AllService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ServiceMapper extends BaseMapper<AllService> {
    List<Map<String, Object>> findOneService();
}
