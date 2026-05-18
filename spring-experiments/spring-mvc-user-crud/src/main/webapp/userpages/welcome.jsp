<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>登录成功</title></head>
<body>
<h2>欢迎 ${username} 用户!</h2>
<hr/>
<h3>您提交的登录信息如下：</h3>
<p>登录账号：${username}</p>
<p>登录密码：${password}</p>
<br/>
<a href="${pageContext.request.contextPath}/user/login">返回登录</a>
</body>
</html>
