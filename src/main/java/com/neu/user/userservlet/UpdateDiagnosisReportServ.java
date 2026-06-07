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

@WebServlet("/updateDiagnosisReport")
public class UpdateDiagnosisReportServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 1. 获取前端传递的参数
        String idStr = req.getParameter("id");
        String diseaseCode = req.getParameter("diseaseCode");
        String diseaseName = req.getParameter("diseaseName");
        String icdCode = req.getParameter("icdCode");
        String diseaseCategory = req.getParameter("diseaseCategory");

        // 2. 封装实体对象
        DiagnosisReport report = new DiagnosisReport();
        report.setId(Integer.parseInt(idStr));
        report.setDiseaseCode(diseaseCode);
        report.setDiseaseName(diseaseName);
        report.setIcdCode(icdCode);
        report.setDiseaseCategory(diseaseCategory);

        // 3. 调用业务层执行修改
        DiagnosisReportBiz biz = new DiagnosisReportBizImpl();
        boolean isSuccess = biz.updateDiagnosisReport(report);

        // 4. 根据结果响应
        if (isSuccess) {
            resp.sendRedirect("findDiagnosisReport");
        } else {
            resp.getWriter().print("<script>alert('修改失败！');history.back();</script>");
        }
    }
}