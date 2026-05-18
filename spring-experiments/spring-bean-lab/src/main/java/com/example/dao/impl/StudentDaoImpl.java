package com.example.dao.impl;

import com.example.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
    @Override
    public void save() {
        System.out.println("StudentDao: 成功连接数据库，学生信息保存成功！");
    }
}