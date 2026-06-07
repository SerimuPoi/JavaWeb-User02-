package com.neu.user.userservlet;

import com.neu.user.biz.DepartmentBiz;
import com.neu.user.biz.impl.DepartmentBizImpl;
import com.neu.user.entity.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findByDepartment")
public class FindByDepartmentServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 获取要查询的ID
        int id = Integer.parseInt(req.getParameter("id"));


        DepartmentBiz biz = new DepartmentBizImpl();
        List<Department> list = biz.findAll();

        Department target = null;
        for (Department d : list) {
            if (d.getId() == id) {
                target = d;
                break;
            }
        }

        req.setAttribute("department", target);
        req.getRequestDispatcher("updateDepartment.jsp").forward(req, resp);
    }
}