package com.example.dormitory.entity;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String stuNum;
    private String name;
    private String gender;
    private String phone;
    // 【修改】宿舍号从 Integer 改成了 String，这样就能保存 "001" 或者 "A栋-101" 了Z
    private String dormId;
    // 【新增】入住时间字段
    private String checkInDate;
    private String photoUrl;
}