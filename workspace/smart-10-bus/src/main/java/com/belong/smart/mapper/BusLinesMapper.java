package com.belong.smart.mapper;

import com.belong.smart.entity.po.BusLines;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 巴士路线表 Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Mapper
public interface BusLinesMapper extends BaseMapper<BusLines> {
    // 根据路线编号查询站点信息
    @MapKey("x")
    List<Map<String, Object>> getStepInfo(@Param("lineId") int lineId);
}
