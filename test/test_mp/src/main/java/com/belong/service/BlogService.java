package com.belong.service;

import com.belong.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author belong
 * @since 2022-03-17
 */
public interface BlogService extends IService<Blog> {
    List<Map<String, Object>> selectAll();
}
