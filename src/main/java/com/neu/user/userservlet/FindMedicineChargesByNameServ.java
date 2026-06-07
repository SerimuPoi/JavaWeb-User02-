package com.neu.user.userservlet;
import com.neu.user.biz.impl.MedicineChargesBizImpl;
import com.neu.user.entity.MedicineCharges;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findMedicineChargesByName")
public class FindMedicineChargesByNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String medName = req.getParameter("medName");
        List<MedicineCharges> all = new MedicineChargesBizImpl().findAll();
        List<MedicineCharges> result = new ArrayList<>();
        if (medName != null && !medName.trim().isEmpty()) {
            for (MedicineCharges m : all) {
                if (m.getMedName() != null && m.getMedName().contains(medName)) { result.add(m); }
            }
        } else { result = all; }
        req.setAttribute("mcList", result);
        req.getRequestDispatcher("findMedicineCharges.jsp").forward(req, resp);
    }
}