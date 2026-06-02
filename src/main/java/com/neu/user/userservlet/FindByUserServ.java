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

@WebServlet("/findByUser")
public class FindByUserServ extends HttpServlet {
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
        UserBiz userBiz = new UserBizImpl();
        //调用查询方法
        User user = userBiz.findByUser(id);
        //将数据存入作用域中
        req.setAttribute("user", user);
        //跳转到修改的页面
        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);

    }
}
