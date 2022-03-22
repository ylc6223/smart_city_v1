package com.belong.smart.service;

import com.belong.smart.entity.po.MetroSteps;
import com.belong.smart.entity.vo.MetroDetialBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地铁城市表 服务类
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
public interface MetroService{
    // 查询地铁站首页
    List<Map<String, Object>> getMetroByName(@Param("name") String name);

    // 获取地铁站详情
    List<MetroDetialBean> getMetroDetial(@Param("id") int id);

    List<MetroSteps> getMetroSteps(@Param("id") int id);
}
