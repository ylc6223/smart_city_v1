package com.belong.smart.service;

import com.belong.smart.entity.po.BusLines;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 巴士路线表 服务类
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
public interface BusLinesService extends IService<BusLines> {
    List<Map<String, Object>> getStepInfo(@Param("lineId") int lineId);
}
