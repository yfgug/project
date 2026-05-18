package com.springmvc.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser == null)
            throw new Exception("未登录，无权限访问系统主页！");
        else {
            if (loginUser.getIdentity().equalsIgnoreCase("学生")
                    && request.getServletPath().equalsIgnoreCase("/system/add")) {
                throw new Exception("学生无权限执行添加操作！");
            }
        }
        return true;
    }
}
