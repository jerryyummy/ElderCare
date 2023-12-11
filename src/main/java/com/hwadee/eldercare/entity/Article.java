package com.hwadee.eldercare.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private int id;
    private String title;
    private String context;
    private String audioUrl;
    private String img;
    private String abstraction;
    private Date time;
    private int authorId;
}
