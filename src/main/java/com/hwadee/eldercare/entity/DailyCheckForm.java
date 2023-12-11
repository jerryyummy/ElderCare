package com.hwadee.eldercare.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("dailycheckform")
public class DailyCheckForm {

    private transient int level;
    private transient String name;
    private transient int age;

    private int id;
    private int uid;
    private int bodyTemp;
    private int pulseRate;
    private int breathRate;
    private int bloodPressure;
    private int bloodOxygen;
    private int bloodSugar;
    private int healthSelfAssessment;
    private int selfCareSelfAssessment;
    private int sportFreq;
    private int diet;
    private int smokeFreq;
    private int drunkFreq;
    private String oral;
    private String vision;
    private String hearing;
    private String sportAbility;
    private int skin;
    private int sclera;
    private int lung;
    private int heart;
    private int abdomen;
    private String bodyCheckSupplement;
    private int auxiliaryCheck;
    private int currentProblem;
    private String otherSupplement;
    private Date time;

}