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
import java.util.List;

@WebServlet("/findByUserServ")
public class FindByUserNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String uname = req.getParameter("uname");
        UserBiz userBiz = new UserBizImpl();

        List<User> users = userBiz.findByUserName(uname);

        req.setAttribute("list", users);
        //直接转发给 "findUser.jsp"，不要转发给 "findUser" 否则数据会被覆盖清空
        req.getRequestDispatcher("findUser.jsp").forward(req, resp);

    }
}
