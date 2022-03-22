package com.belong.smart.service.impl;

import com.belong.smart.entity.po.HospitalImg;
import com.belong.smart.entity.po.HospitalRegistration;
import com.belong.smart.entity.po.HospitalRegistrationTypes;
import com.belong.smart.mapper.HospitalMapper;
import com.belong.smart.service.HospitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Resource
    HospitalMapper hospitalMapper;

    @Override
    public List<HospitalImg> getImgList(int hospitalId) {
        return hospitalMapper.getImgList(hospitalId);
    }

    @Override
    public HospitalRegistration getHospitaInfo(int id) {
        return hospitalMapper.getHospitaInfo(id);
    }

    @Override
    public List<HospitalRegistration> getHospitaList() {
        return hospitalMapper.getHospitaList();
    }

    @Override
    public List<HospitalRegistration> searchHospital(String hospitalName) {
        return hospitalMapper.searchHospital(hospitalName);
    }

    @Override
    public List<HospitalRegistrationTypes> getType(int did) {
        return hospitalMapper.getType(did);
    }

    @Override
    public List<Map<String, Object>> getReserveList(int userId) {
        return hospitalMapper.getReserveList(userId);
    }

    @Override
    public List<Map<String, Object>> getReserveDetail(int id) {
        return hospitalMapper.getReserveDetail(id);
    }


}
