package com.belong.smart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.belong.smart.entity.po.SysUser;
import com.belong.smart.entity.vo.ProfileDetialBean;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户和角色关联表 Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-18
 */
@Mapper
public interface ProfileMapper extends BaseMapper<SysUser> {
    // 获取用户详细信息
    List<ProfileDetialBean> getDetial(@Param("id") int id);

    @MapKey("xx")
    List<Map<String, Object>> getDetial2(@Param("id") int id);

    // 查询用户基本信息
    @MapKey("xx")
    List<Map<String, Object>> getUserBaseInfo(@Param("id") int id);

    // 查询用户意见反馈列表
    @MapKey("xx")
    List<Map<String, Object>> getFBList(@Param("id") int id);

    @MapKey("xx")
    List<Map<String, Object>> getFBDetial(@Param("id") int id);

    // 新增意见反馈
    int addFB(@Param("userId") int userId, @Param("content") String content);

}
