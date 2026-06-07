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

@WebServlet("/findDepartment")
public class FindDepartmentServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        DepartmentBiz biz = new DepartmentBizImpl();
        List<Department> list = biz.findAll();
        req.setAttribute("deptList", list);
        req.getRequestDispatcher("/findDepartment.jsp").forward(req, resp);
    }
}
