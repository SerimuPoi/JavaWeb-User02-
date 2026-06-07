package com.neu.user.userservlet;

import com.neu.user.biz.RegistrationBiz;
import com.neu.user.biz.impl.RegistrationBizImpl;
import com.neu.user.entity.Registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findRegistration")
public class FindRegistrationServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        RegistrationBiz biz = new RegistrationBizImpl();
        List<Registration> list = biz.findAll();

        req.setAttribute("regList", list);
        req.getRequestDispatcher("findRegistration.jsp").forward(req, resp);
    }
}