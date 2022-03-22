package com.belong.smart.mapper;

import com.belong.smart.entity.HouseSource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Mapper
public interface HouseSourceMapper extends BaseMapper<HouseSource> {
    // 查询房源列表
    List<HouseSource> getHouseList();

    // 查询房源详情
    HouseSource getHouseDetial(@Param("id") int id);

    // 根据房源名称模糊查询
    List<HouseSource> getHouseByName(@Param("name") String name);

    // 根据分类查询房源
    List<HouseSource> getHouseByType(@Param("type") int type);
}
