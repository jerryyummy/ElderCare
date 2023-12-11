package com.hwadee.eldercare.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ratingform")
public class RatingForm {

    private transient Integer level;

    @TableId("user_id")
    private int userId;
    private int checked;
    private String name;
    private int age;
    private String dailyScore;
    private String mentalScore;
    private String senseScore;
    private String socialScore;
    private String activityScore;
    private String medCareScore;
    private String diseaseScore;
    private String medCareDescription;
    private String diseaseDescription;
    private String diseaseHistory;
    private String drugHistory;
    private String exposureHistory;
    private String familyHistory;
    private String societySupport;
}
