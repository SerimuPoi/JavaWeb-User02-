package com.neu.user.biz;

import com.neu.user.entity.User;

import java.util.List;

public interface UserBiz {
    public User login(String uname, String upwd);
    public List<User> findUsers();

    List<User> findUser();
    public int delUser(int id);
}
