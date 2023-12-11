package com.hwadee.eldercare.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String faceUrl;
    private String role;
}
