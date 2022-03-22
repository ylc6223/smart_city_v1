package com.belong.service.impl;

import com.belong.entity.Blog;
import com.belong.mapper.BlogMapper;
import com.belong.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-17
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
    @Resource
    BlogMapper blogMapper;

    @Override
    public List<Map<String, Object>> selectAll() {
        return blogMapper.selectAll();
    }
}
