package com.neu.user.userservlet;

import com.neu.user.biz.PrescriptionBiz;
import com.neu.user.biz.impl.PrescriptionBizImpl;
import com.neu.user.entity.Prescription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findByPrescription")
public class FindByPrescriptionServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 1. 获取要查询的 ID
        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            // 2. 调用业务层查询
            PrescriptionBiz biz = new PrescriptionBizImpl();
            List<Prescription> list = biz.findAll();

            // 3. 筛选目标对象
            Prescription target = null;
            for (Prescription p : list) {
                if (p.getId() == id) {
                    target = p;
                    break;
                }
            }

            // 4. 存入作用域并转发
            req.setAttribute("prescription", target);
            req.getRequestDispatcher("updatePrescription.jsp").forward(req, resp);
        }
    }
}