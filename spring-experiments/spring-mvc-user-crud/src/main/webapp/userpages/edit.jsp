<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>编辑用户信息</title></head>
<body>
<h2>编辑用户信息 (Spring MVC数据绑定)</h2>
<form action="${pageContext.request.contextPath}/user/update" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <table>
        <tr><td>用户ID：</td><td><input type="text" value="${user.id}" disabled></td></tr>
        <tr><td>姓名：</td><td><input type="text" name="name" value="${user.name}"></td></tr>
        <tr><td>密码：</td><td><input type="password" name="password" value="${user.password}"></td></tr>
        <tr><td>邮箱：</td><td><input type="text" name="email" value="${user.email}"></td></tr>
        <tr><td>电话：</td><td><input type="text" name="phone" value="${user.phone}"></td></tr>
        <tr><td>地址：</td><td><input type="text" name="address" value="${user.address}"></td></tr>
        <tr><td colspan="2"><input type="submit" value="提交修改"></td></tr>
    </table>
</form>
</body>
</html>
