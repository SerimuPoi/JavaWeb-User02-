package com.neu.user.userservlet;

import com.neu.user.biz.UserBiz;
import com.neu.user.biz.impl.UserBizImpl;
import com.neu.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        int type = Integer.parseInt(req.getParameter("type"));
        //根据数据创建对象
        User user = new User(uname,upwd,type);
        //调用addUser
        UserBiz userBiz = new UserBizImpl();
        int count = userBiz.addUser(user);
        if (count > 0) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }

    }
}
