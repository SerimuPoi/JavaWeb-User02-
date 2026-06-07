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
import java.math.BigDecimal;

@WebServlet("/addMedicineCharges")
public class AddMedicineChargesServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 1. 获取前端传递的参数
        String medCode = req.getParameter("medCode");
        String medName = req.getParameter("medName");
        String medQuantityStr = req.getParameter("medQuantity");
        String medPriceStr = req.getParameter("medPrice");

        // 2. 封装实体对象
        MedicineCharges mc = new MedicineCharges();
        mc.setMedCode(medCode);
        mc.setMedName(medName);

        if (medQuantityStr != null && !medQuantityStr.isEmpty()) {
            mc.setMedQuantity(Integer.parseInt(medQuantityStr));
        }
        if (medPriceStr != null && !medPriceStr.isEmpty()) {
            mc.setMedPrice(new Integer(medPriceStr));
        }

        // 3. 调用业务层执行添加
        MedicineChargesBiz biz = new MedicineChargesBizImpl();
        boolean isSuccess = biz.addMedicineCharges(mc);

        // 4. 根据结果响应
        if (isSuccess) {
            resp.sendRedirect("findMedicineCharges");
        } else {
            resp.getWriter().print("<script>alert('添加失败！');history.back();</script>");
        }
    }
}