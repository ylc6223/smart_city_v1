package com.belong.smart.service;

import com.belong.smart.entity.CarApt;
import com.baomidou.mybatisplus.extension.service.IService;
import com.belong.smart.entity.Cars;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 预约表 服务类
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
public interface CarAptService extends IService<CarApt> {
    List<Map<String, Object>> getAptList(@Param("userId") int userId);
    int updateCars(Cars cars);

}
