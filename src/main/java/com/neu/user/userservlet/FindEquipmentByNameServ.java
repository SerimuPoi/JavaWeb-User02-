package com.neu.user.userservlet;
import com.neu.user.biz.impl.EquipmentBizImpl;
import com.neu.user.entity.Equipment;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findEquipmentByName")
public class FindEquipmentByNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String equipName = req.getParameter("equipName");
        List<Equipment> all = new EquipmentBizImpl().findAll();
        List<Equipment> result = new ArrayList<>();
        if (equipName != null && !equipName.trim().isEmpty()) {
            for (Equipment e : all) {
                if (e.getEquipName() != null && e.getEquipName().contains(equipName)) { result.add(e); }
            }
        } else { result = all; }
        req.setAttribute("equipList", result);
        req.getRequestDispatcher("findEquipment.jsp").forward(req, resp);
    }
}