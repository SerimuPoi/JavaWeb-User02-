package com.neu.user.userservlet;

import com.neu.user.biz.PrescriptionBiz;
import com.neu.user.biz.impl.PrescriptionBizImpl;
import com.neu.user.entity.Prescription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet("/addPrescription")
public class AddPrescriptionServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 1. 获取前端参数
        String presCode = req.getParameter("presCode");
        String presDateStr = req.getParameter("presDate"); // 格式应为 yyyy-MM-dd
        String patientName = req.getParameter("patientName");
        String presFeeStr = req.getParameter("presFee");

        // 2. 封装实体对象
        Prescription p = new Prescription();
        p.setPresCode(presCode);
        p.setPatientName(patientName);

        if (presDateStr != null && !presDateStr.isEmpty()) {
            p.setPresDate(Date.valueOf(presDateStr));
        }
        if (presFeeStr != null && !presFeeStr.isEmpty()) {
            p.setPresFee(new Integer(presFeeStr));
        }

        // 3. 业务层处理
        PrescriptionBiz biz = new PrescriptionBizImpl();
        boolean isSuccess = biz.addPrescription(p);

        // 4. 响应结果
        if (isSuccess) {
            resp.sendRedirect("findPrescription");
        } else {
            resp.getWriter().print("<script>alert('添加失败！');history.back();</script>");
        }
    }
}