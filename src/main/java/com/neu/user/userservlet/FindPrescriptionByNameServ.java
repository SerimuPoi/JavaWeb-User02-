package com.neu.user.userservlet;
import com.neu.user.biz.impl.PrescriptionBizImpl;
import com.neu.user.entity.Prescription;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findPrescriptionByName")
public class FindPrescriptionByNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String patientName = req.getParameter("patientName");
        List<Prescription> all = new PrescriptionBizImpl().findAll();
        List<Prescription> result = new ArrayList<>();
        if (patientName != null && !patientName.trim().isEmpty()) {
            for (Prescription p : all) {
                if (p.getPatientName() != null && p.getPatientName().contains(patientName)) { result.add(p); }
            }
        } else { result = all; }
        req.setAttribute("presList", result);
        req.getRequestDispatcher("findPrescription.jsp").forward(req, resp);
    }
}