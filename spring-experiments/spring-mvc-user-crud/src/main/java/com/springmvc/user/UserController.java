package com.springmvc.user;

import com.springmvc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // ========== 功能1: 登录数据绑定 ==========

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
    public String loginSubmit(String uname, String upass, Model model) {
        model.addAttribute("username", uname);
        model.addAttribute("password", upass);
        return "welcome";
    }

    // ========== 功能2: 查询用户 → 编辑 → 提交 ==========

    @RequestMapping("/query")
    public String toQuery() {
        return "query";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(Integer userId, Model model) {
        UserInfo user = userService.getUserById(userId);
        if (user == null) {
            model.addAttribute("error", "用户不存在，请检查ID!");
            return "query";
        }
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") UserInfo user, Model model) {
        userService.updateUser(user);
        model.addAttribute("user", user);
        return "show";
    }
}
