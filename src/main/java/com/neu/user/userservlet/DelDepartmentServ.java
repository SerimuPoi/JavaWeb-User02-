package com.neu.user.userservlet;

import com.neu.user.biz.DepartmentBiz;
import com.neu.user.biz.impl.DepartmentBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delDepartment")
public class DelDepartmentServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            DepartmentBiz biz = new DepartmentBizImpl();
            boolean isSuccess = biz.deleteDepartment(id);
            if (isSuccess) {
                resp.sendRedirect("findDepartment");
            }
        }
    }
}
