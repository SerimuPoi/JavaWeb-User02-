package com.neu.user.userservlet;

import com.neu.user.biz.EquipmentBiz;
import com.neu.user.biz.impl.EquipmentBizImpl;
import com.neu.user.entity.Equipment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEquipment")
public class UpdateEquipmentServ extends HttpServlet {
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
        String equipCode = req.getParameter("equipCode");
        String equipName = req.getParameter("equipName");
        String equipCategory = req.getParameter("equipCategory");
        String equipQuantityStr = req.getParameter("equipQuantity");

        Equipment equip = new Equipment();
        equip.setId(Integer.parseInt(idStr));
        equip.setEquipCode(equipCode);
        equip.setEquipName(equipName);
        equip.setEquipCategory(equipCategory);

        if (equipQuantityStr != null && !equipQuantityStr.isEmpty()) {
            equip.setEquipQuantity(Integer.parseInt(equipQuantityStr));
        }

        EquipmentBiz biz = new EquipmentBizImpl();
        boolean isSuccess = biz.updateEquipment(equip);

        if (isSuccess) {
            resp.sendRedirect("findEquipment");
        } else {
            resp.getWriter().print("<script>alert('修改失败！');history.back();</script>");
        }
    }
}