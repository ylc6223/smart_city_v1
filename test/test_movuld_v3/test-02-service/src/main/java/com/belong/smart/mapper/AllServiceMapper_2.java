package com.belong.smart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.belong.smart.entity.AllService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AllServiceMapper_2 extends BaseMapper<AllService> {
    List<AllService> findAll();
}
