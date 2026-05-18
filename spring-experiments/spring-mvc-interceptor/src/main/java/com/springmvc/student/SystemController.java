package com.springmvc.student;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/loginCheck")
    public String loginCheck(User user, HttpServletRequest request) {
        String sql = "select * from users where number=? and password=? and identity=?";
        Object[] obj = new Object[] {
                user.getNumber(),
                user.getPassword(),
                user.getIdentity()
        };
        RowMapper<User> rowMapper;
        rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> user_db = jdbcTemplate.query(sql, rowMapper, obj);
        if (!user_db.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/system/main";
        }
        else {
            request.setAttribute("msg", "用户信息错误");
            return "login1";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/system/login";
    }

    @RequestMapping("/query")
    public String query() {
        return "query";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }
}
