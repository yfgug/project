package com.springmvc.user.dao;

import com.springmvc.user.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static final Map<Integer, UserInfo> userDB = new HashMap<>();

    static {
        UserInfo u1 = new UserInfo();
        u1.setId(1);
        u1.setName("张三");
        u1.setPassword("123456");
        u1.setEmail("zhangsan@example.com");
        u1.setPhone("13800138001");
        u1.setAddress("北京市海淀区");
        userDB.put(1, u1);

        UserInfo u2 = new UserInfo();
        u2.setId(2);
        u2.setName("李四");
        u2.setPassword("654321");
        u2.setEmail("lisi@example.com");
        u2.setPhone("13900139002");
        u2.setAddress("上海市浦东新区");
        userDB.put(2, u2);
    }

    public UserInfo findById(Integer id) {
        return userDB.get(id);
    }

    public void update(UserInfo user) {
        userDB.put(user.getId(), user);
    }
}
