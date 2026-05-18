package com.springmvc.user.service;

import com.springmvc.user.UserInfo;
import com.springmvc.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserInfo getUserById(Integer id) {
        return userDao.findById(id);
    }

    public void updateUser(UserInfo user) {
        userDao.update(user);
    }
}
