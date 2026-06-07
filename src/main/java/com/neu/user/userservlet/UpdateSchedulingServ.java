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
import java.sql.Date;

@WebServlet("/updateScheduling")
public class UpdateSchedulingServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 1. 获取参数
        String idStr = req.getParameter("id");
        String doctorIdStr = req.getParameter("doctorId");
        String doctorName = req.getParameter("doctorName");
        String doctorType = req.getParameter("doctorType");
        String scheduleDateStr = req.getParameter("scheduleDate");

        // 2. 封装对象
        Scheduling s = new Scheduling();
        s.setId(Integer.parseInt(idStr));
        s.setDoctorName(doctorName);
        s.setDoctorType(doctorType);

        if (doctorIdStr != null && !doctorIdStr.isEmpty()) {
            s.setDoctorId(Integer.parseInt(doctorIdStr));
        }
        if (scheduleDateStr != null && !scheduleDateStr.isEmpty()) {
            s.setScheduleDate(Date.valueOf(scheduleDateStr));
        }

        // 3. 业务层
        SchedulingBiz biz = new SchedulingBizImpl();
        boolean isSuccess = biz.updateScheduling(s);

        // 4. 响应
        if (isSuccess) {
            resp.sendRedirect("findScheduling");
        } else {
            resp.getWriter().print("<script>alert('修改失败！');history.back();</script>");
        }
    }
}