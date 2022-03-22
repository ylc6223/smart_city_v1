package com.belong.smart.mapper;

import com.belong.smart.entity.RotationChart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 轮播图 Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-16
 */
@Mapper
//@Repository
public interface RotationChartMapper extends BaseMapper<RotationChart> {
    List<String> selectUrl();
}
