package com.hwadee.eldercare.service;

import com.hwadee.eldercare.entity.*;

import java.util.List;

public interface PatientInfoService {

    /**
     * 获取用户的信息列表
     * @return 用户信息列表
     */
    List<Patient> getPatientList();

    /**
     * 通过用户的id获取用户提交的评估申请
     * @param id 用户Id
     * @return 某个用户的历史评估申请
     */
    public List<RatingForm> getRatingFormById(int id);

    void addDailyCheckForm(DailyCheckForm dailyCheckForm);

    void setRating(int id,int level);

    void addRatingForm(RatingForm ratingForm);

    List<RatingForm> getRatingFormList();

    void insertEmergency(Emergency emergency);

    List<Emergency> getEmergencyList();

    void checkEmergency(int id);

    List<DailyCheckForm> getDailyCheckFormList();

    List<DailyCheckForm> getDailyCheckFromById(int id);

    RatingForm getSingleRatingFormById(int id);
}
