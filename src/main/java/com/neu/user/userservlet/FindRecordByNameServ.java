package com.neu.user.userservlet;
import com.neu.user.biz.impl.RecordBizImpl;
import com.neu.user.entity.Record;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findRecordByName")
public class FindRecordByNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String patientName = req.getParameter("patientName");
        List<Record> all = new RecordBizImpl().findAll();
        List<Record> result = new ArrayList<>();
        if (patientName != null && !patientName.trim().isEmpty()) {
            for (Record r : all) {
                if (r.getPatientName() != null && r.getPatientName().contains(patientName)) { result.add(r); }
            }
        } else { result = all; }
        req.setAttribute("recordList", result);
        req.getRequestDispatcher("findRecord.jsp").forward(req, resp);
    }
}