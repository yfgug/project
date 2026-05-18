package com.experiment.aop;

import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Override
    public void addStudent(Student student) {
        System.out.println("执行业务逻辑：添加了学生 -> " + student.getName());
    }

    @Override
    public void updateStudent(Student student) {
        System.out.println("执行业务逻辑：更新了学生 -> " + student.getName());
    }

    @Override
    public void deleteStudent(String studentId) {
        System.out.println("执行业务逻辑：删除了学号为 -> " + studentId + " 的学生");
    }

    @Override
    public Student getStudent(String studentId) {
        System.out.println("执行业务逻辑：查询学号为 -> " + studentId + " 的学生");
        return new Student(studentId, "测试学生", 20, "软件一班");
    }
}