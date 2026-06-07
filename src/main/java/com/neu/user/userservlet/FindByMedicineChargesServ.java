package com.neu.user.userservlet;

import com.neu.user.biz.MedicineChargesBiz;
import com.neu.user.biz.impl.MedicineChargesBizImpl;
import com.neu.user.entity.MedicineCharges;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findByMedicineCharges")
public class FindByMedicineChargesServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));

        MedicineChargesBiz biz = new MedicineChargesBizImpl();
        List<MedicineCharges> list = biz.findAll();

        MedicineCharges target = null;
        for (MedicineCharges m : list) {
            if (m.getId() == id) {
                target = m;
                break;
            }
        }

        req.setAttribute("medicineCharges", target);
        req.getRequestDispatcher("updateMedicineCharges.jsp").forward(req, resp);
    }
}