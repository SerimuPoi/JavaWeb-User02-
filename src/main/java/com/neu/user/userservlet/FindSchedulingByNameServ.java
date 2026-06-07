package com.neu.user.userservlet;
import com.neu.user.biz.impl.SchedulingBizImpl;
import com.neu.user.entity.Scheduling;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findSchedulingByName")
public class FindSchedulingByNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String doctorName = req.getParameter("doctorName");
        List<Scheduling> all = new SchedulingBizImpl().findAll();
        List<Scheduling> result = new ArrayList<>();
        if (doctorName != null && !doctorName.trim().isEmpty()) {
            for (Scheduling s : all) {
                if (s.getDoctorName() != null && s.getDoctorName().contains(doctorName)) { result.add(s); }
            }
        } else { result = all; }
        req.setAttribute("schedList", result);
        req.getRequestDispatcher("findScheduling.jsp").forward(req, resp);
    }
}