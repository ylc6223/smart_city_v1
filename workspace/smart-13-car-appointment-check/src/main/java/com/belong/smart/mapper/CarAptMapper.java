package com.belong.smart.mapper;

import com.belong.smart.entity.CarApt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.belong.smart.entity.Cars;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预约表 Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Mapper
public interface CarAptMapper extends BaseMapper<CarApt> {
    // 查询预约检车订单
    @MapKey("")
    List<Map<String, Object>> getAptList(@Param("userId") int userId);

    // 修改车辆
    int updateCars(Cars cars);
}
