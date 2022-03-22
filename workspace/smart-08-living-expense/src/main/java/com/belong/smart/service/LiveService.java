package com.belong.smart.service;

import com.belong.smart.entity.po.LiveHouseholder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LiveService {
    List<Map<String, Object>> getTypeList(Map<String, Object> map);
    List<LiveHouseholder> getPayInfo(@Param("userId") int userId);
    List<Map<String, Object>> getPayDetial(@Param("userId") int userId, @Param("doorNo") int doorNO);
    int payByDoor(LiveHouseholder liveHouseholder);

}
