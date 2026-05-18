<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>学生管理系统</title>
    </head>
    <body>
        <h1>查询页面</h1>
        <table>
            <tr>
                <td>学号：</td><td><input type="text" name="number"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="查询信息">
                    <input type="button" value="查询成绩">
                    <input type="button" value="返回"
                        onclick="window.location.href='${pageContext.request.contextPath}/system/main'">
                </td>
            </tr>
        </table>
    </body>
</html>
