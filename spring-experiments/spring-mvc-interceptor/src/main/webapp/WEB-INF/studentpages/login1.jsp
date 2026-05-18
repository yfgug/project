<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>学生管理系统</title>
    </head>
    <body>
        <h1>登录页面</h1>
        <form action="${pageContext.request.contextPath}/system/loginCheck" method="post">
            <table>
                <tr><td>账号：</td><td><input type="text" name="number"></td></tr>
                <tr><td>密码：</td><td><input type="password" name="password"></td></tr>
                <tr><td>身份：</td><td><input type="text" name="identity"></td></tr>
                <tr><td colspan="2" align="center"><input type="submit" value="登录"></td></tr>
            </table>
        </form>
        <c:if test="${not empty msg}">
            <p style="color:red">${msg}</p>
        </c:if>
    </body>
</html>
