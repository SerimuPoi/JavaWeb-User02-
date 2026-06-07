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

@WebServlet("/findEquipment")
public class FindEquipmentServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        EquipmentBiz biz = new EquipmentBizImpl();
        List<Equipment> list = biz.findAll();

        req.setAttribute("equipList", list);
        req.getRequestDispatcher("findEquipment.jsp").forward(req, resp);
    }
}