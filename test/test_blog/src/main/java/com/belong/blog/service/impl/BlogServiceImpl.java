package com.belong.blog.service.impl;

import com.belong.blog.entity.Blog;
import com.belong.blog.mapper.BlogMapper;
import com.belong.blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-15
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
