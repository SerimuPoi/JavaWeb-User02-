package com.neu.user.userservlet;
import com.neu.user.biz.impl.DiagnosisReportBizImpl;
import com.neu.user.entity.DiagnosisReport;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findDiagnosisReportByName")
public class FindDiagnosisReportByNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String diseaseName = req.getParameter("diseaseName");
        List<DiagnosisReport> all = new DiagnosisReportBizImpl().findAll();
        List<DiagnosisReport> result = new ArrayList<>();
        if (diseaseName != null && !diseaseName.trim().isEmpty()) {
            for (DiagnosisReport r : all) {
                if (r.getDiseaseName() != null && r.getDiseaseName().contains(diseaseName)) { result.add(r); }
            }
        } else { result = all; }
        req.setAttribute("reportList", result);
        req.getRequestDispatcher("findDiagnosisReport.jsp").forward(req, resp);
    }
}