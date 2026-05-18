<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>学生管理系统</title>
    </head>
    <body>
        <h1>添加页面</h1>
        <table>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="添加信息"
                        onclick="window.location.href='${pageContext.request.contextPath}/system/addInfor'">
                    <input type="button" value="添加成绩">
                    <input type="button" value="返回"
                        onclick="window.location.href='${pageContext.request.contextPath}/system/main'">
                </td>
            </tr>
        </table>
    </body>
</html>
