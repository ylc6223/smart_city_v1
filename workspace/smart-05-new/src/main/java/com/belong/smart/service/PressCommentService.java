package com.belong.smart.service;

import com.belong.smart.entity.PressComment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 新闻评论表 服务类
 * </p>
 *
 * @author belong
 * @since 2022-03-17
 */
public interface PressCommentService extends IService<PressComment> {
    List<Map<String, Object>> selectCommentList(@Param("press_id") int press_id);

}
