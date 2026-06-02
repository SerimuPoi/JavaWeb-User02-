package com.neu.user.userservlet;
import com.neu.user.biz.UserBiz;
import com.neu.user.biz.impl.UserBizImpl;
import com.neu.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //过去前端传来的参数
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        //创建UserBiz对象
        UserBiz userBiz = new UserBizImpl();
        //调用登录的方法
        User user = userBiz.login(uname, upwd);
        //将user存入作用域中
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        if (user!=null){
                if (user.getType()==1) {
                req.getRequestDispatcher("index.html").forward(req, resp);
                }else if (user.getType()==2) {
                req.getRequestDispatcher("doctor.jsp").forward(req, resp);
                }else if (user.getType()==3) {
                req.getRequestDispatcher("finUser.jsp").forward(req, resp);
                }

        } else {
                resp.sendRedirect("login.jsp");
        }
    }
}
