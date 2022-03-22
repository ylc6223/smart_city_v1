package com.belong.smart.mapper;

import com.belong.smart.entity.po.MetroSteps;
import com.belong.smart.entity.vo.MetroDetialBean;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地铁城市表 Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Mapper
public interface MetroMapper  {
    // 查询地铁站首页
    @MapKey("xx")
    List<Map<String, Object>> getMetroByName(@Param("name") String name);

    // 获取地铁站详情
    List<MetroDetialBean> getMetroDetial(@Param("id") int id);

    List<MetroSteps> getMetroSteps(@Param("id") int id);
}
