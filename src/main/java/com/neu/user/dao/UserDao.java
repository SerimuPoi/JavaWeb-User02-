package com.neu.user.dao;

import com.neu.user.entity.User;

import java.util.List;

public interface UserDao {
    public User login(String uname, String upwd);

    public List<User> findUsers();

    public List<User> findUser();

    public int delUser(int id);

    public User findByUser(int id);

    public int updateUser(User user);

    public int addUser(User user);

    public List<User> findByUserName(String uname);

}
