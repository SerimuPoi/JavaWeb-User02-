package com.neu.user.userservlet;

import com.neu.user.biz.DiagnosisReportBiz;
import com.neu.user.biz.impl.DiagnosisReportBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delDiagnosisReport")
public class DelDiagnosisReportServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String idStr = req.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            DiagnosisReportBiz biz = new DiagnosisReportBizImpl();
            boolean isSuccess = biz.deleteDiagnosisReport(id);

            if (isSuccess) {
                resp.sendRedirect("findDiagnosisReport");
            }
        }
    }
}
