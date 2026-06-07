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
import java.util.List;

@WebServlet("/findByEquipment")
public class FindByEquipmentServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));

        EquipmentBiz biz = new EquipmentBizImpl();
        List<Equipment> list = biz.findAll();

        Equipment target = null;
        for (Equipment e : list) {
            if (e.getId() == id) {
                target = e;
                break;
            }
        }

        req.setAttribute("equipment", target);
        req.getRequestDispatcher("updateEquipment.jsp").forward(req, resp);
    }
}