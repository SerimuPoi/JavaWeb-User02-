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

@WebServlet("/updateMedicineCharges")
public class UpdateMedicineChargesServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String idStr = req.getParameter("id");
        String medCode = req.getParameter("medCode");
        String medName = req.getParameter("medName");
        String medQuantityStr = req.getParameter("medQuantity");
        String medPriceStr = req.getParameter("medPrice");

        MedicineCharges mc = new MedicineCharges();
        mc.setId(Integer.parseInt(idStr));
        mc.setMedCode(medCode);
        mc.setMedName(medName);

        if (medQuantityStr != null && !medQuantityStr.isEmpty()) {
            mc.setMedQuantity(Integer.parseInt(medQuantityStr));
        }
        if (medPriceStr != null && !medPriceStr.isEmpty()) {
            mc.setMedPrice(new Integer(medPriceStr));
        }

        MedicineChargesBiz biz = new MedicineChargesBizImpl();
        boolean isSuccess = biz.updateMedicineCharges(mc);

        if (isSuccess) {
            resp.sendRedirect("findMedicineCharges");
        } else {
            resp.getWriter().print("<script>alert('修改失败！');history.back();</script>");
        }
    }
}