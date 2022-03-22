package com.belong.smart.service.impl;

import com.belong.smart.entity.po.BusLines;
import com.belong.smart.mapper.BusLinesMapper;
import com.belong.smart.service.BusLinesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 巴士路线表 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Service
public class BusLinesServiceImpl extends ServiceImpl<BusLinesMapper, BusLines> implements BusLinesService {
    @Resource
    BusLinesMapper mapper;
    @Override
    public List<Map<String, Object>> getStepInfo(int lineId) {
        return mapper.getStepInfo(lineId);
    }
}
