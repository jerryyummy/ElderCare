package com.hwadee.eldercare.entity;

import lombok.Data;

@Data
public class Emergency {
    private transient String name;
    private int id;
    private int uid;
    private String checked;
    private String description;
    private String path;
}
