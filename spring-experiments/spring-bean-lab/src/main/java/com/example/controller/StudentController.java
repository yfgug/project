package com.example.controller;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("studentController")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void save() {
        System.out.println("StudentController: 接收到保存学生的请求...");
        studentService.saveStudent();
    }
}