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

@WebServlet("/findMedicineCharges")
public class FindMedicineChargesServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        MedicineChargesBiz biz = new MedicineChargesBizImpl();
        List<MedicineCharges> list = biz.findAll();

        req.setAttribute("mcList", list);
        req.getRequestDispatcher("findMedicineCharges.jsp").forward(req, resp);
    }
}