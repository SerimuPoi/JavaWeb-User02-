package com.neu.user.userservlet;
import com.neu.user.biz.impl.DepartmentBizImpl;
import com.neu.user.entity.Department;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findDepartmentByName")
public class FindDepartmentByNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String deptName = req.getParameter("deptName");
        List<Department> all = new DepartmentBizImpl().findAll();
        List<Department> result = new ArrayList<>();
        if (deptName != null && !deptName.trim().isEmpty()) {
            for (Department d : all) {
                if (d.getDeptName() != null && d.getDeptName().contains(deptName)) { result.add(d); }
            }
        } else { result = all; }
        req.setAttribute("deptList", result);
        req.getRequestDispatcher("findDepartment.jsp").forward(req, resp);
    }
}