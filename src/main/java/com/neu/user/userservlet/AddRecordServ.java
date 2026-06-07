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

@WebServlet("/addRecord")
public class AddRecordServ extends HttpServlet {
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
        String recordCode = req.getParameter("recordCode");
        String recordDateStr = req.getParameter("recordDate"); // 格式应为 yyyy-MM-dd
        String patientName = req.getParameter("patientName");

        // 2. 封装实体对象
        Record r = new Record();
        r.setRecordCode(recordCode);
        r.setPatientName(patientName);

        if (recordDateStr != null && !recordDateStr.isEmpty()) {
            r.setRecordDate(Date.valueOf(recordDateStr));
        }

        // 3. 业务层处理
        RecordBiz biz = new RecordBizImpl();
        boolean isSuccess = biz.addRecord(r);

        // 4. 响应结果
        if (isSuccess) {
            resp.sendRedirect("findRecord");
        } else {
            resp.getWriter().print("<script>alert('添加失败！');history.back();</script>");
        }
    }
}