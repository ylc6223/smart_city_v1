package com.belong.smart.service.impl;

import com.belong.smart.entity.PressComment;
import com.belong.smart.mapper.PressCommentMapper;
import com.belong.smart.service.PressCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 新闻评论表 服务实现类
 * </p>
 *
 * @author belong
 * @since 2022-03-17
 */
@Service
public class PressCommentServiceImpl extends ServiceImpl<PressCommentMapper, PressComment> implements PressCommentService {
    @Resource
    PressCommentMapper mapper;

    @Override
    public List<Map<String, Object>> selectCommentList(int press_id) {
        return mapper.selectCommentList(press_id);
    }
}
