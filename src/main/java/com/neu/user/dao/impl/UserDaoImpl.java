package com.neu.user.dao.impl;

import com.neu.user.dao.UserDao;
import com.neu.user.entity.User;
import com.neu.user.util.BaseDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public User login(String uname, String upwd) {
        String sql = "select * from user1 where uname=? and upwd=?";
        super.query(sql, uname, upwd);
        User user = null;
        try {
            if (rs != null && rs.next()){
                // 【核心修复】使用列名代替数字下标，防止顺序不一致引发异常
                user = new User(
                        rs.getInt("id"),
                        rs.getString("uname"),
                        rs.getString("upwd"),
                        rs.getInt("type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.close();
        }
        return user;
    }

    @Override
    public List<User> findUsers() {
        return this.findUser();
    }

    @Override
    public List<User> findUser() {
        List<User> list = new ArrayList<User>();
        String sql = "select * from user1";
        super.query(sql);
        try {
            if (rs != null) {
                while (rs.next()){
                    // 【核心修复】这里也同步改为使用列名获取
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("uname"),
                            rs.getString("upwd"),
                            rs.getInt("type")
                    );
                    list.add(user);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            super.close();
        }
        return list;
    }

    @Override
    public int delUser(int id) {
        String sql = "delete from user1 where id=?";
        int count = super.update(sql, id);
        return count;
    }

    @Override
    public User findByUser(int id) {
        User user = null;
        String sql = "select * from user1 where id=?";
        super.query(sql, id);
        try {
            if (rs.next()) {
                user= new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public int updateUser(User user) {
        String sql = "update user1 set uname=?,upwd=?,type=? where id=?";
        int count = super.update(sql, user.getUname(), user.getUpwd(), user.getType(), user.getId());
        return count;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user1 (uname,upwd,type) values(?,?,?)";
        int count = super.update(sql, user.getUname(), user.getUpwd(), user.getType());
        return count;
    }

    @Override
    public List<User> findByUserName(String uname) {
        List<User> list = new ArrayList<User>();
        String sql = "select * from user1 where uname like ?";
        super.query(sql, "%" + uname + "%");
        try {
            while (rs.next()){
                User user= new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                list.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}