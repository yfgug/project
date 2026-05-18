package com.test;

import com.spring.jdbc.JdbcTemplate.Account;
import com.spring.jdbc.JdbcTemplate.AccountManage;
import com.spring.transaction.ann.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountManage accountManage = context.getBean("accountManage", AccountManage.class);

        System.out.println("--- 1. 测试查询所有账户 ---");
        System.out.println(accountManage.queryAllAccount());

        System.out.println("\n--- 2. 测试插入新账户 ---");
        accountManage.addAccount(new Account(null, "王五", 500.0));

        System.out.println("\n--- 3. 测试转账功能 (张三给李四转 200) ---");
        accountManage.transfer(1, 2, 200.0);

        System.out.println("\n--- 4. 转账后查询 ---");
        System.out.println(accountManage.queryAllAccount());

        context.close();
    }
}
