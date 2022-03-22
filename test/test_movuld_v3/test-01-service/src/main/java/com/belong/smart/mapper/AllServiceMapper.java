package com.belong.smart.mapper;

import com.belong.smart.entity.AllService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 全部服务表 Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Mapper
public interface AllServiceMapper extends BaseMapper<AllService> {
    List<AllService> findAll();
}
