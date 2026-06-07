package com.neu.user.userservlet;
import com.neu.user.entity.Department;
import com.neu.user.biz.DepartmentBiz;
import com.neu.user.biz.impl.DepartmentBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDepartment")
public class AddDepartmentServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String deptCode = req.getParameter("deptCode");
        String deptName = req.getParameter("deptName");
        String deptCategory = req.getParameter("deptCategory");
        String deptType = req.getParameter("deptType");

        Department dept = new Department();
        dept.setDeptCode(deptCode);
        dept.setDeptName(deptName);
        dept.setDeptCategory(deptCategory);
        dept.setDeptType(deptType);

        DepartmentBiz biz = new DepartmentBizImpl();
        boolean isSuccess = biz.addDepartment(dept);
        if (isSuccess) {
            resp.sendRedirect("findDepartment.jsp");
        }
    }
}
