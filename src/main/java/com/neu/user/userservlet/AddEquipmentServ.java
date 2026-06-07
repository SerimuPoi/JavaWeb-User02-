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

@WebServlet("/addEquipment")
public class AddEquipmentServ extends HttpServlet {
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
        String equipCode = req.getParameter("equipCode");
        String equipName = req.getParameter("equipName");
        String equipCategory = req.getParameter("equipCategory");
        String equipQuantityStr = req.getParameter("equipQuantity");

        // 2. 封装实体对象
        Equipment equip = new Equipment();
        equip.setEquipCode(equipCode);
        equip.setEquipName(equipName);
        equip.setEquipCategory(equipCategory);

        if (equipQuantityStr != null && !equipQuantityStr.isEmpty()) {
            equip.setEquipQuantity(Integer.parseInt(equipQuantityStr));
        }

        // 3. 业务层处理
        EquipmentBiz biz = new EquipmentBizImpl();
        boolean isSuccess = biz.addEquipment(equip);

        // 4. 响应结果
        if (isSuccess) {
            resp.sendRedirect("findEquipment");
        } else {
            resp.getWriter().print("<script>alert('添加失败！');history.back();</script>");
        }
    }
}