package com.belong.smart.service.impl;

import com.belong.smart.entity.HouseSource;
import com.belong.smart.mapper.HouseSourceMapper;
import com.belong.smart.service.HouseSourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Service
public class HouseSourceServiceImpl extends ServiceImpl<HouseSourceMapper, HouseSource> implements HouseSourceService {
    @Resource
    HouseSourceMapper houseSourceMapper;

    @Override
    public List<HouseSource> getHouseList() {
        return houseSourceMapper.getHouseList();
    }

    @Override
    public HouseSource getHouseDetial(int id) {
        return houseSourceMapper.getHouseDetial(id);
    }

    @Override
    public List<HouseSource> getHouseByName(String name) {
        return houseSourceMapper.getHouseByName(name);
    }

    @Override
    public List<HouseSource> getHouseByType(int type) {
        return houseSourceMapper.getHouseByType(type);
    }
}
