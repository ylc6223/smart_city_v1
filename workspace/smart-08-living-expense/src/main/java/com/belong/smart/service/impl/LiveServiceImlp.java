package com.belong.smart.service.impl;

import com.belong.smart.entity.po.LiveHouseholder;
import com.belong.smart.mapper.LiveMapper;
import com.belong.smart.service.LiveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LiveServiceImlp  implements LiveService {
    @Resource
    LiveMapper liveMapper;

    @Override
    public List<Map<String, Object>> getTypeList(Map<String, Object> map) {
        return liveMapper.getTypeList(map);
    }

    @Override
    public List<LiveHouseholder> getPayInfo(int userId) {
        return liveMapper.getPayInfo(userId);
    }

    @Override
    public List<Map<String, Object>> getPayDetial(int userId, int doorNO) {
        return liveMapper.getPayDetial(userId, doorNO);
    }

    @Override
    public int payByDoor(LiveHouseholder liveHouseholder) {
        return liveMapper.payByDoor(liveHouseholder);
    }
}
