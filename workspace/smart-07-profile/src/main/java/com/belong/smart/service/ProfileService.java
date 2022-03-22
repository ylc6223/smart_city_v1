package com.belong.smart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.belong.smart.entity.po.SysUser;
import com.belong.smart.entity.vo.ProfileDetialBean;
import com.belong.smart.mapper.ProfileMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
public interface ProfileService extends IService<SysUser> {
    List<ProfileDetialBean> getDetial(@Param("id") int id);
    List<Map<String, Object>> getUserBaseInfo(@Param("id") int id);
    List<Map<String, Object>> getFBList(@Param("id") int id);
    List<Map<String, Object>> getFBDetial(@Param("id") int id);
    int addFB(@Param("userId") int userId, @Param("content") String content);
}
