package com.belong.smart.service.impl;

import com.belong.smart.entity.po.MetroSteps;
import com.belong.smart.entity.vo.MetroDetialBean;
import com.belong.smart.mapper.MetroMapper;
import com.belong.smart.service.MetroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 地铁城市表 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Service
public class MetroServiceImpl implements MetroService {
    @Resource MetroMapper mapper;

    @Override
    public List<Map<String, Object>> getMetroByName(String name) {
        return mapper.getMetroByName(name);
    }

    @Override
    public List<MetroDetialBean> getMetroDetial(int id) {
        return mapper.getMetroDetial(id);
    }

    @Override
    public List<MetroSteps> getMetroSteps(int id) {
        return mapper.getMetroSteps(id);
    }
}
