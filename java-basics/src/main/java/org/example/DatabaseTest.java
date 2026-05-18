package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseTest {

    // ================== ⚠️ 请在这里修改你的数据库配置 ⚠️ ==================
    // 数据库连接 URL（java_test 是我们刚才建的库名，后面的参数是为了防止中文乱码和时区报错）
    private static final String URL = "jdbc:mysql://localhost:3306/java_test?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8";

    // 你的 MySQL 用户名（通常是 root）
    private static final String USER = "root";

    // 你的 MySQL 密码（改成你自己的密码！！！）
    private static final String PASSWORD = "123456";
    // =====================================================================

    public static void main(String[] args) {
        System.out.println("🔄 正在尝试连接 MySQL 数据库...");

        // 这里的 try-with-resources 语法会自动帮我们关闭数据库连接，防止资源泄露
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("✅ 数据库连接成功！准备读取数据...\n");

            // 1. 写一句 SQL 查询语句
            String sql = "SELECT id, username, age FROM users";

            // 2. 将 SQL 语句发送给数据库
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                System.out.println("-------------------------");
                System.out.println("ID\t姓名\t\t年龄");
                System.out.println("-------------------------");

                // 3. 循环解析数据库返回的结果
                int count = 0;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("username");
                    int age = resultSet.getInt("age");

                    System.out.println(id + "\t" + name + "\t\t" + age);
                    count++;
                }
                System.out.println("-------------------------");
                System.out.println("🎉 恭喜！成功从数据库中读取了 " + count + " 条数据！");

            }
        } catch (SQLException e) {
            System.err.println("❌ 数据库连接或查询失败！请检查以下几点：");
            System.err.println("1. 你的 MySQL 服务有没有启动？");
            System.err.println("2. 账号 (USER) 和密码 (PASSWORD) 填对了吗？");
            System.err.println("3. URL 里的端口 3306 是否正确？");
            System.err.println("详细错误信息如下：");
            e.printStackTrace();
        }
    }
}