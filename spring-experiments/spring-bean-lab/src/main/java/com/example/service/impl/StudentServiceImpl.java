package com.example.service.impl;

import com.example.dao.StudentDao;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void saveStudent() {
        System.out.println("StudentService: 正在处理保存学生业务逻辑...");
        studentDao.save();
    }
}