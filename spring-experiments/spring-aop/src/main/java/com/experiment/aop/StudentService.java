package com.experiment.aop;

public interface StudentService {
    void addStudent(Student student); // 添加学生信息 [cite: 12]
    void updateStudent(Student student); // 更新学生信息 [cite: 13]
    void deleteStudent(String studentId); // 删除学生信息 [cite: 14]
    Student getStudent(String studentId); // 根据学号查询学生信息 [cite: 15]
}