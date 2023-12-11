package com.hwadee.eldercare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.hwadee.eldercare.entity.RatingForm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RatingFormMapper extends BaseMapper<RatingForm> {

    @Select("select * from ratingform join patient where id=user_id")
    public List<RatingForm> getRatingFormList();

    @Select("select * from ratingform join patient where id=user_id and id=#{id}")
    public RatingForm getSingleRatingForm(int id);
}
