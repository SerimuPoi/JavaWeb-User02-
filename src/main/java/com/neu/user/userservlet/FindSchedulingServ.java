package com.neu.user.userservlet;

import com.neu.user.biz.SchedulingBiz;
import com.neu.user.biz.impl.SchedulingBizImpl;
import com.neu.user.entity.Scheduling;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findScheduling")
public class FindSchedulingServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        SchedulingBiz biz = new SchedulingBizImpl();
        List<Scheduling> list = biz.findAll();

        req.setAttribute("schedList", list);
        req.getRequestDispatcher("findScheduling.jsp").forward(req, resp);
    }
}