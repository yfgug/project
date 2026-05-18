package com.example.dormitory.entity;

import lombok.Data;

@Data
public class Repair {
    private Integer id;
    private String stuName;
    private String dormId;
    private String device;
    private String description;
    private String status;
    private String submitDate;
    private String photoUrl;
}
