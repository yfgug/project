# 小米 MIMO 开发者 Token 申请 — AI/Agent 开发成果

## 使用 AI/Agent 驱动构建的具体成果

我主要用 Claude Code 辅助完成了两套完整的后端业务系统，以及配套的 Spring 全家桶技术实验。

---

### 1. 校园宿舍管理系统（Spring Boot + MyBatis + MySQL）

搭了一套校园宿舍管理后台，包含三个核心模块：

- **学生管理** — 增删改查、多条件组合搜索（姓名/性别/宿舍号/入住日期范围）、批量删除、头像上传（格式白名单 + 大小校验）
- **报修工单** — 完整流转链路：提交 → 处理中 → 已解决 → 删除
- **公告管理** — 发布、编辑、删除

技术细节：
- 后端 Spring Boot 2.5 + MyBatis 2.2，RESTful API，统一 Result<T> 响应体
- 自己写了一套登录防暴力破解，基于 ConcurrentHashMap 记录失败次数，同一账号 3 次输错锁 5 秒
- 文件上传做了后缀白名单（jpg/jpeg/png/gif/bmp/webp）+ 2MB 上限，UUID 重命名防覆盖
- MyBatis 动态 SQL 做组合条件查询（`<if>` + `<foreach>` 批量删除）
- YAML 管理多环境配置，HikariCP 连接池，日志落盘

AI 辅助点：Controller/Service/Mapper 模板代码生成、MyBatis 动态 SQL 编写、跨域和文件上传配置的查漏补缺。

---

### 2. 电商平台（Servlet + JSP + c3p0 + DBUtils）

用原生 Servlet 从零写了一个功能完整的电商 demo：

- **用户模块** — 注册、登录（Session 管理）、注销、改密、修改收货地址
- **商品模块** — 多级分类浏览、分页查询、关键词模糊搜索、商品详情
- **推荐系统** — 三种推荐位：滚动横幅（scroll）、热门推荐（hot）、新品推荐（new），后台可配置推荐关系
- **购物车** — 基于 Session，前端异步请求加入购物车，后端校验库存
- **订单模块** — 购物车结算、订单生成、支付方式选择

技术细节：DAO 层 Apache DBUtils（QueryRunner + MapListHandler/BeanHandler），c3p0 连接池，Filter 全局编码处理。

AI 辅助点：DAO 层 SQL 拼接、前端异步交互的 JS 片段、分页逻辑的参数计算。

---

### 3. Spring 生态实验

顺带做了一系列 Spring 技术验证：

- **Spring AOP** — AspectJ 注解实现切面日志（@Before/@After/@Pointcut）
- **Spring JDBC + 事务** — JdbcTemplate + DataSourceTransactionManager，纯 Java Config 零 XML
- **Spring MVC 拦截器** — 自定义 HandlerInterceptor，按角色（学生/教师）控制接口访问权限
- **Spring Bean 分层架构** — Controller → Service → DAO 三层实践

---

## 实际使用数据

- 日常开发基本全程用 Claude Code，日均消耗约 **30-50 万 Token**
- 规律性强的代码（Mapper/Service/实体类）交给 AI 出第一版，自己 review 业务逻辑，编码效率提升约 **50%-60%**
- 传统手写需要两周的项目（如电商平台），AI 辅助下压缩到约一周
- 从 Java SE → Servlet → Spring → Spring Boot 的完整技术栈学习周期从预估 3 个月压缩到约 6 周

---

## 后续计划

- 把宿舍管理系统接上小程序前端，继续 AI 辅助全栈开发
- 尝试将 AI Agent 集成到后端工作流中，做自动化代码 review 和单元测试生成
- 探索利用 MIMO 的能力做更复杂的多步骤任务编排
