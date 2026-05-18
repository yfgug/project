package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UndergradTest {

    // 【测试1：Lombok 偷懒魔法】
    // @Data 会自动在后台生成 get/set 方法，@AllArgsConstructor 会生成全参构造函数
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Student {
        private Integer id;
        private String name;
        private String major;
    }

    public static void main(String[] args) {
        System.out.println("🚀 正在启动本科常用 Java 环境综合体检...");
        System.out.println("--------------------------------------------------");

        // 1. 测试 Lombok 是否生效
        try {
            Student student = new Student(1, "大学生", "计算机科学与技术");
            // 如果下面这行能用 student.getName() 而不报错，说明 Lombok 完美运行！
            System.out.println("✅ [Lombok 测试] 成功！获取到学生姓名: " + student.getName());
        } catch (Exception e) {
            System.err.println("❌ [Lombok 测试] 失败，请检查是否开启了 Annotation Processors。");
        }

        // 2. 测试 MySQL 驱动是否能找到
        try {
            // 这行代码专门用来寻找 MySQL 的 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ [MySQL 驱动测试] 成功！随时可以连接数据库 (Driver 已就绪)。");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ [MySQL 驱动测试] 失败，没有找到 mysql-connector-java 依赖。");
        }

        // 3. 测试 Servlet API 是否就绪
        try {
            // 这行代码寻找 Java Web 最核心的 HttpServlet 类
            Class.forName("javax.servlet.http.HttpServlet");
            System.out.println("✅ [Servlet API 测试] 成功！Web 开发核心类库已就绪。");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ [Servlet API 测试] 失败，没有找到 javax.servlet-api 依赖。");
        }

        System.out.println("--------------------------------------------------");
        System.out.println("🎉 体检完毕：你的 IDEA 已经武装到牙齿，任何本科实验课都不在话下！");
    }
}