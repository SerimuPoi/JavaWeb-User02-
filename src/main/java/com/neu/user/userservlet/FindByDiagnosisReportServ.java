package com.neu.user.userservlet;

import com.neu.user.biz.DiagnosisReportBiz;
import com.neu.user.biz.impl.DiagnosisReportBizImpl;
import com.neu.user.entity.DiagnosisReport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findByDiagnosisReport")
public class FindByDiagnosisReportServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));

        DiagnosisReportBiz biz = new DiagnosisReportBizImpl();
        List<DiagnosisReport> list = biz.findAll();

        DiagnosisReport target = null;
        for (DiagnosisReport r : list) {
            if (r.getId() == id) {
                target = r;
                break;
            }
        }

        req.setAttribute("report", target);
        req.getRequestDispatcher("updateDiagnosisReport.jsp").forward(req, resp);
    }
}