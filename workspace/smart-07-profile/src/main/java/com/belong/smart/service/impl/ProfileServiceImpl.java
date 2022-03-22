package com.belong.smart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.belong.smart.entity.po.SysUser;
import com.belong.smart.entity.vo.ProfileDetialBean;
import com.belong.smart.mapper.ProfileMapper;
import com.belong.smart.service.ProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Service
public class ProfileServiceImpl extends ServiceImpl<ProfileMapper, SysUser> implements ProfileService {
    @Resource
    ProfileMapper mapper;
    @Override
    public List<ProfileDetialBean> getDetial(int id) {
        return  mapper.getDetial(id);
    }

    @Override
    public List<Map<String, Object>> getUserBaseInfo(int id) {
        return mapper.getUserBaseInfo(id);
    }

    @Override
    public List<Map<String, Object>> getFBList(int id) {
        return mapper.getFBList(id);
    }

    @Override
    public List<Map<String, Object>> getFBDetial(int id) {
        return mapper.getFBDetial(id);
    }

    @Override
    public int addFB(int userId, String content) {
        int i = mapper.addFB(userId, content);
        return i;
    }
}
