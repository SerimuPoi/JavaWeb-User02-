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

@WebServlet("/updateUser")
public class UpdateUserServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        int type = Integer.parseInt(req.getParameter("type"));

        User user = new User(id, uname, upwd, type);

        UserBiz userBiz = new UserBizImpl();
        int count = userBiz.updateUser(user);
        if (count > 0) {
            req.getRequestDispatcher("findUser").forward(req, resp);
        }
    }
}
