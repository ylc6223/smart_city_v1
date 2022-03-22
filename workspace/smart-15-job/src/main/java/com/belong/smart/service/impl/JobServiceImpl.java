package com.belong.smart.service.impl;

import com.belong.smart.entity.JobResume;
import com.belong.smart.mapper.JobMapper;
import com.belong.smart.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {
    @Resource
    JobMapper jobMapper;

    @Override
    public List<Map<String, Object>> getHotList() {
        return jobMapper.getHotList();
    }

    @Override
    public List<Map<String, Object>> getPostList() {
        return jobMapper.getPostList();
    }

    @Override
    public List<Map<String, Object>> getPostListById(int professionId) {
        return jobMapper.getPostListById(professionId);
    }

    @Override
    public List<Map<String, Object>> getPostListByName(String name) {
        return jobMapper.getPostListByName(name);
    }

    @Override
    public List<Map<String, Object>> getPostDetial(int id) {
        return jobMapper.getPostDetial(id);
    }

    @Override
    public List<Map<String, Object>> getCompanyById(int id) {
        return jobMapper.getCompanyById(id);
    }

    @Override
    public int updateResume(JobResume jobResume) {
        return jobMapper.updateResume(jobResume);
    }
}
