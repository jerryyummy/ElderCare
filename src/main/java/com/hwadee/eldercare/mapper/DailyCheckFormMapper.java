package com.hwadee.eldercare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwadee.eldercare.entity.DailyCheckForm;
import com.hwadee.eldercare.entity.Emergency;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DailyCheckFormMapper extends BaseMapper<DailyCheckForm> {

    @Select("select * from dailycheckform join patient where uid=patient.id")
    List<DailyCheckForm> getDailyCheckFormList();

    @Select("select * from dailycheckform join patient where uid = patient.id and uid = #{id} order by time")
    List<DailyCheckForm> getSingleCheckFormList(int id);
}
