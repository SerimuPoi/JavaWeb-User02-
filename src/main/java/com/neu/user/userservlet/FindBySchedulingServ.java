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

@WebServlet("/findByScheduling")
public class FindBySchedulingServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            SchedulingBiz biz = new SchedulingBizImpl();
            List<Scheduling> list = biz.findAll();

            Scheduling target = null;
            for (Scheduling s : list) {
                if (s.getId() == id) {
                    target = s;
                    break;
                }
            }

            req.setAttribute("scheduling", target);
            req.getRequestDispatcher("updateScheduling.jsp").forward(req, resp);
        }
    }
}