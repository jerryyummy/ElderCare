package com.hwadee.eldercare.service.Impl;

import com.hwadee.eldercare.entity.*;
import com.hwadee.eldercare.mapper.DailyCheckFormMapper;
import com.hwadee.eldercare.mapper.EmergencyMapper;
import com.hwadee.eldercare.mapper.PatientMapper;
import com.hwadee.eldercare.mapper.RatingFormMapper;
import com.hwadee.eldercare.service.PatientInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class PatientInfoServiceImpl implements PatientInfoService {

    @Resource
    PatientMapper patientMapper;
    @Resource
    DailyCheckFormMapper dailyCheckFormMapper;
    @Resource
    RatingFormMapper ratingFormMapper;
    @Resource
    EmergencyMapper emergencyMapper;

    @Override
    public List<Patient> getPatientList() {
        return patientMapper.selectList(null);
    }

    @Override
    public List<RatingForm> getRatingFormById(int id) {
        return null;
    }

    @Override
    public void addDailyCheckForm(DailyCheckForm dailyCheckForm) {
        dailyCheckFormMapper.insert(dailyCheckForm);
    }

    @Override
    public void setRating(int id, int level) {
        Patient patient = new Patient();
        patient.setId(id);
        patient.setLevel(level);
        RatingForm ratingForm = ratingFormMapper.selectById(id);
        ratingForm.setChecked(1);
        ratingFormMapper.updateById(ratingForm);
        patientMapper.updateById(patient);
    }

    @Override
    public void addRatingForm(RatingForm form) {
        RatingForm old = ratingFormMapper.selectById(form.getUserId());
        if (Objects.nonNull(old)) {
            ratingFormMapper.updateById(form);
        } else {
            ratingFormMapper.insert(form);
        }
    }

    @Override
    public List<RatingForm> getRatingFormList() { return ratingFormMapper.getRatingFormList(); }

    @Override
    public void insertEmergency(Emergency emergency) { emergencyMapper.insert(emergency); }

    @Override
    public List<Emergency> getEmergencyList() {
        return emergencyMapper.getEmergencyList();
    }

    @Override
    public void checkEmergency(int id) {
        Emergency emergency = new Emergency();
        emergency.setId(id);
        emergency.setChecked("1");
        emergencyMapper.updateById(emergency);
    }

    @Override
    public List<DailyCheckForm> getDailyCheckFormList() {
        return dailyCheckFormMapper.getDailyCheckFormList();
    }

    @Override
    public List<DailyCheckForm> getDailyCheckFromById(int id){
        return dailyCheckFormMapper.getSingleCheckFormList(id);
    }

    @Override
    public RatingForm getSingleRatingFormById(int id) {
        return ratingFormMapper.getSingleRatingForm(id);
    }
}
