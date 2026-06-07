package com.neu.user.userservlet;
import com.neu.user.entity.DiagnosisReport;
import com.neu.user.biz.DiagnosisReportBiz;
import com.neu.user.biz.impl.DiagnosisReportBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDiagnosisReport")
public class AddDiagnosisReportServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String diseaseCode = req.getParameter("diseaseCode");
        String diseaseName= req.getParameter("diseaseName");
        String icdCode= req.getParameter("icdCode");
        String diseaseCategory = req.getParameter("diagnosisCategory");

        DiagnosisReport report = new DiagnosisReport();
        report.setDiseaseCode(diseaseCode);
        report.setDiseaseName(diseaseName);
        report.setIcdCode(icdCode);
        report.setDiseaseCategory(diseaseCategory);

        DiagnosisReportBiz biz = new DiagnosisReportBizImpl();
        boolean isSuccess = biz.addDiagnosisReport(report);
        if (isSuccess) {
            resp.sendRedirect("findDepartment.jsp");
        }
    }
}
