package com.belong.smart.mapper;

import com.belong.smart.entity.PressComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 新闻评论表 Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-17
 */
@Mapper
public interface PressCommentMapper extends BaseMapper<PressComment> {
    @MapKey("xx")
    List<Map<String, Object>> selectCommentList(@Param("press_id") int press_id);
}
