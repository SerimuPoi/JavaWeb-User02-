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
import java.util.List;

@WebServlet("/findByRecord")
public class FindByRecordServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            RecordBiz biz = new RecordBizImpl();
            List<Record> list = biz.findAll();

            Record target = null;
            for (Record r : list) {
                if (r.getId() == id) {
                    target = r;
                    break;
                }
            }

            req.setAttribute("record", target);
            req.getRequestDispatcher("updateRecord.jsp").forward(req, resp);
        }
    }
}