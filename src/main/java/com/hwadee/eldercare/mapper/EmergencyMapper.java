package com.hwadee.eldercare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.eldercare.entity.Emergency;
import com.hwadee.eldercare.entity.RatingForm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmergencyMapper extends BaseMapper<Emergency> {

    @Select("select * from emergency join patient where uid=patient.id")
    List<Emergency> getEmergencyList();

}
