package com.experiment.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 1. 加载 Spring 配置文件并创建应用上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 获取被 AOP 代理的 StudentService Bean
        StudentService studentService = (StudentService) context.getBean("studentService");

        // 3. 创建测试学生对象 [cite: 9]
        Student stu = new Student("2026455", "栾佳豪", 23, "计算机科学2班");

        // 4. 调用业务方法触发 AOP [cite: 12, 13, 14, 15]
        studentService.addStudent(stu);
        studentService.updateStudent(stu);
        studentService.getStudent("2026455");
        studentService.deleteStudent("2026455");
    }
}