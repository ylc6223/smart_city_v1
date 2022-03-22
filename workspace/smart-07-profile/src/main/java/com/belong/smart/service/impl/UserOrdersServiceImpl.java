package com.belong.smart.service.impl;

import com.belong.smart.entity.po.UserOrders;
import com.belong.smart.mapper.UserOrdersMapper;
import com.belong.smart.service.UserOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户订单表 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-20
 */
@Service
public class UserOrdersServiceImpl extends ServiceImpl<UserOrdersMapper, UserOrders> implements UserOrdersService {

}
