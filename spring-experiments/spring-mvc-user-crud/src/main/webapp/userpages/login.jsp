<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>用户登录</title></head>
<body>
<h2>用户登录</h2>
<form action="${pageContext.request.contextPath}/user/loginSubmit" method="post">
    <table>
        <tr><td>账号：</td><td><input type="text" name="uname"></td></tr>
        <tr><td>密码：</td><td><input type="password" name="upass"></td></tr>
        <tr><td colspan="2"><input type="submit" value="登录"></td></tr>
    </table>
</form>
</body>
</html>
