package com.hwadee.eldercare.entity;

import lombok.Data;

@Data
public class Patient{
    private int id;
    private int age;
    private int gender;
    private int level;

    private String name;
    private String phoneNum;
    private String address;
    private String photo;

    private double height;
    private double weight;

}
