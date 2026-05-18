<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>用户信息展示</title></head>
<body>
<h2>用户信息修改成功!</h2>
<hr/>
<h3>修改后的用户信息如下：</h3>
<table border="1" cellpadding="5">
    <tr><td>用户ID：</td><td>${user.id}</td></tr>
    <tr><td>姓名：</td><td>${user.name}</td></tr>
    <tr><td>密码：</td><td>${user.password}</td></tr>
    <tr><td>邮箱：</td><td>${user.email}</td></tr>
    <tr><td>电话：</td><td>${user.phone}</td></tr>
    <tr><td>地址：</td><td>${user.address}</td></tr>
</table>
<br/>
<a href="${pageContext.request.contextPath}/user/query">继续编辑</a>
</body>
</html>
