<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>查询用户</title></head>
<body>
<h2>查询用户信息</h2>
<form action="${pageContext.request.contextPath}/user/edit" method="post">
    请输入要编辑的用户ID：<input type="text" name="userId">
    <input type="submit" value="查询并编辑">
</form>
<p style="color:red;">${error}</p>
<br/>
<a href="${pageContext.request.contextPath}/user/login">前往登录页面</a>
</body>
</html>
