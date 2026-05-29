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
        String sql = "select * from user where uname=? and upwd=?";
        super.query(sql, uname, upwd);
        User user = null; // 在 try 外部声明 user 对象
        try {
            // 增加 rs != null 判断，防止抛出空指针异常
            if (rs != null && rs.next()){
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close();
        }
        return user; // 返回查询到的对象，而不是固定返回 null
    }

    @Override
    public List<User> findUsers() {
        return this.findUser();
    }

    @Override
    public List<User> findUser() {
        List<User> list = new ArrayList<User>();
        String sql = "select * from user";
        super.query(sql);
        try {
            if (rs != null) {
                while (rs.next()){
                    User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    list.add(user);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            super.close(); // 【关键修复】查询完毕后一定要释放连接
        }
        return list;
    }

    @Override
    public int delUser(int id) {
        String sql = "delete from user where id=?";
        int count = super.update(sql, id); // 获取受影响的行数
        return count; // 返回真实结果
    }
}
