package com.belong.smart.service;

import com.belong.smart.entity.po.HospitalImg;
import com.belong.smart.entity.po.HospitalRegistration;
import com.belong.smart.entity.po.HospitalRegistrationTypes;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HospitalService {
    List<HospitalImg> getImgList(int hospitalId);
    HospitalRegistration getHospitaInfo(@Param("id") int id);
    List<HospitalRegistration> getHospitaList();
    List<HospitalRegistration> searchHospital(@Param("hospitalName") String hospitalName);
    List<HospitalRegistrationTypes> getType(@Param("did") int did);
    List<Map<String, Object>> getReserveList(@Param("userId") int userId);
    List<Map<String, Object>> getReserveDetail(@Param("id") int id);



}
