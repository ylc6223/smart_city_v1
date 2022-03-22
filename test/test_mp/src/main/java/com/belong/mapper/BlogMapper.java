package com.belong.mapper;

import com.belong.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-17
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    @MapKey("title")
    List<Map<String, Object>> selectAll();
}
