package com.example.test;

import com.example.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        StudentController studentController = (StudentController) context.getBean("studentController");

        studentController.save();
    }
}