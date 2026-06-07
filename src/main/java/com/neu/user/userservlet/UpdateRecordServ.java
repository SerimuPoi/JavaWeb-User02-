package com.neu.user.userservlet;

import com.neu.user.biz.RecordBiz;
import com.neu.user.biz.impl.RecordBizImpl;
import com.neu.user.entity.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/updateRecord")
public class UpdateRecordServ extends HttpServlet {
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
        String recordCode = req.getParameter("recordCode");
        String recordDateStr = req.getParameter("recordDate");
        String patientName = req.getParameter("patientName");

        // 2. 封装对象
        Record r = new Record();
        r.setId(Integer.parseInt(idStr));
        r.setRecordCode(recordCode);
        r.setPatientName(patientName);

        if (recordDateStr != null && !recordDateStr.isEmpty()) {
            r.setRecordDate(Date.valueOf(recordDateStr));
        }

        // 3. 业务处理
        RecordBiz biz = new RecordBizImpl();
        boolean isSuccess = biz.updateRecord(r);

        // 4. 响应
        if (isSuccess) {
            resp.sendRedirect("findRecord");
        } else {
            resp.getWriter().print("<script>alert('修改失败！');history.back();</script>");
        }
    }
}