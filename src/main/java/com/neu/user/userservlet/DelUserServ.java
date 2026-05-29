package com.neu.user.userservlet;

import com.neu.user.biz.UserBiz;
import com.neu.user.biz.impl.UserBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUser")
public class DelUserServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        UserBiz userBiz = new UserBizImpl();
        int id = Integer.parseInt(req.getParameter("id"));

        int count = userBiz.delUser(id);

        if (count > 0) {
            req.getRequestDispatcher("findUser").forward(req, resp);

        }
    }
}
