package com.belong.smart.service;

import com.belong.smart.entity.JobResume;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface JobService {
    // 查询热门职位
    @MapKey("x")
    List<Map<String, Object>> getHotList();

    // 查询求职列表
    @MapKey("x")
    List<Map<String, Object>> getPostList();

    // 根据热门职位编号查询职位信息
    @MapKey("x")
    List<Map<String, Object>> getPostListById(@Param("professionId") int professionId);

    // 根据职位名称搜索职位
    @MapKey("x")
    List<Map<String, Object>> getPostListByName(@Param("name") String name);

    // 查询职位详情
    @MapKey("x")
    List<Map<String, Object>> getPostDetial(@Param("id") int id);

    // 根据公司编号查询公司信息
    @MapKey("x")
    List<Map<String, Object>> getCompanyById(@Param("id") int id);

    // 修改用户求职信息
    int updateResume(JobResume jobResume);
}
