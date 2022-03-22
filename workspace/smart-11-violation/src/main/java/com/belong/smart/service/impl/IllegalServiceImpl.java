package com.belong.smart.service.impl;

import com.belong.smart.entity.Illegal;
import com.belong.smart.mapper.IllegalMapper;
import com.belong.smart.service.IllegalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 违章查询 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-21
 */
@Service
public class IllegalServiceImpl extends ServiceImpl<IllegalMapper, Illegal> implements IllegalService {

}
