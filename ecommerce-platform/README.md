# 电商平台 - 依赖说明

本项目为非 Maven 的 Servlet 传统项目，运行时需要在 `web/WEB-INF/lib/` 下放置以下 JAR 包：

| JAR 包 | 说明 |
|--------|------|
| mysql-connector-java-8.0.15.jar | MySQL JDBC 驱动 |
| c3p0-0.9.5.2.jar | 数据库连接池 |
| mchange-commons-java-0.2.11.jar | c3p0 依赖 |
| commons-dbutils-1.7.jar | Apache DBUtils |
| commons-beanutils-1.9.3.jar | Bean 工具 |
| commons-logging-1.2.jar | 日志 |
| commons-fileupload-1.3.3.jar | 文件上传 |
| commons-io-2.6.jar | IO 工具 |
| jstl-1.2.jar | JSTL 标签库 |
| druid-1.2.16.jar | Druid 连接池（备选） |

前端资源（Bootstrap、jQuery、FlexSlider、Layer 等）需从官网/CDN 获取后放入 `web/` 对应目录。
