package org.example;

import com.google.gson.Gson; // 如果 Maven 下载成功，这行就不会报错报红

public class Main {
    public static void main(String[] args) {
        // 1. 测试基础的 Java 环境是否跑得通
        System.out.println("🎉 Hello, Java 22! 你的基础运行环境一切正常！");

        // 2. 测试刚才引入的 Gson 架包是否能正常工作
        try {
            Gson gson = new Gson();
            String[] testArray = {"Maven依赖", "测试", "成功"};

            // 将 Java 数组转换成 JSON 格式的字符串
            String jsonOutput = gson.toJson(testArray);

            System.out.println("📦 Gson 架包调用成功，转换结果为: " + jsonOutput);
        } catch (Exception e) {
            System.out.println("❌ 架包测试失败，请检查 Maven 依赖是否下载完成！");
            e.printStackTrace();
        }
    }
}