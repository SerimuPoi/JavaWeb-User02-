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

@WebServlet("/findDiagnosisReport")
public class FindDiagnosisReportServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        DiagnosisReportBiz biz = new DiagnosisReportBizImpl();
        List<DiagnosisReport> list = biz.findAll();

        req.setAttribute("reportList", list);
        req.getRequestDispatcher("findDiagnosisReport.jsp").forward(req, resp);
    }
}