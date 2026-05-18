package com.example.dormitory.entity;

import lombok.Data;

@Data
public class Notice {
    private Integer id;
    private String title;
    private String publisher;
    private String content;
    private String publishDate;
    private String photoUrl;
}
