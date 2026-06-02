package com.neu.user.biz.impl;

import com.neu.user.biz.UserBiz;
import com.neu.user.dao.UserDao;
import com.neu.user.dao.impl.UserDaoImpl;
import com.neu.user.entity.User;

import java.util.Collections;
import java.util.List;

public class UserBizImpl implements UserBiz {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String uname, String upwd) {
        return userDao.login(uname,upwd);
    }

    @Override
    public List<User> findUsers() {
        List<User> list = userDao.findUser();
        return list;
    }

    @Override
    public List<User> findUser() {
        // 修复：直接调用 userDao 获取数据，或者直接写 return findUsers();
        return userDao.findUser();
    }

    @Override
    public int delUser(int id) {
        return userDao.delUser(id);
    }

    @Override
    public User findByUser(int id) {
        return userDao.findByUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> findByUserName(String uname) {
        return userDao.findByUserName(uname);
    }
}
