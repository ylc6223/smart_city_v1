package com.belong.smart.mapper;

import com.belong.smart.entity.po.LiveHouseholder;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface LiveMapper {
    // 查询缴费类型列表
    @MapKey("xx")
    List<Map<String, Object>> getTypeList(Map<String, Object> map);
    // 查询用户生活缴费信息
    List<LiveHouseholder> getPayInfo(@Param("userId") int userId);

    // 查询缴费详情
    @MapKey("xx")
    List<Map<String, Object>> getPayDetial(@Param("userId") int userId, @Param("doorNo") int doorNO);

    // 根据户号缴费
    int payByDoor(LiveHouseholder liveHouseholder);
}
