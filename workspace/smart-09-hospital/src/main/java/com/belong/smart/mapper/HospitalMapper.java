package com.belong.smart.mapper;

import com.belong.smart.entity.po.HospitalImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.belong.smart.entity.po.HospitalRegistration;
import com.belong.smart.entity.po.HospitalRegistrationTypes;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医院轮播图 Mapper 接口
 * </p>
 *
 * @author belong
 * @since 2022-03-20
 */
@Mapper
public interface HospitalMapper extends BaseMapper<HospitalImg> {
    // 获取医院轮播图
    List<HospitalImg> getImgList(@Param("hospitalId") int hospitalId);
    // 根据医院id查询医院信息
    HospitalRegistration getHospitaInfo(@Param("id") int id);
    // 查询医院列表
    List<HospitalRegistration> getHospitaList();
    // 根据名称搜索医院列表
    List<HospitalRegistration> searchHospital(@Param("hospitalName") String hospitalName);

    // 查询专家与普通下的科室分类
    List<HospitalRegistrationTypes> getType(@Param("did") int did);

    // 获取用户预约列表
    @MapKey("xx")
    List<Map<String, Object>> getReserveList(@Param("userId") int userId);

    // 根据预约编号查询预约详情
    @MapKey("xx")
    List<Map<String, Object>> getReserveDetail(@Param("id") int id);
}
