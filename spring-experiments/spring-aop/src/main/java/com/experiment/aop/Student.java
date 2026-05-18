package com.experiment.aop;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String className;

    // 构造函数、Getter 和 Setter
    public Student(String studentId, String name, int age, String className) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    @Override
    public String toString() {
        return "Student{学号='" + studentId + "', 姓名='" + name + "', 年龄=" + age + ", 班级='" + className + "'}";
    }
}