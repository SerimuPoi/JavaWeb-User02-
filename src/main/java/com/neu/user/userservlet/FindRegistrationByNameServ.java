package com.neu.user.userservlet;
import com.neu.user.biz.impl.RegistrationBizImpl;
import com.neu.user.entity.Registration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findRegistrationByName")
public class FindRegistrationByNameServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String regName = req.getParameter("regName");
        List<Registration> all = new RegistrationBizImpl().findAll();
        List<Registration> result = new ArrayList<>();
        if (regName != null && !regName.trim().isEmpty()) {
            for (Registration r : all) {
                if (r.getRegName() != null && r.getRegName().contains(regName)) { result.add(r); }
            }
        } else { result = all; }
        req.setAttribute("regList", result);
        req.getRequestDispatcher("findRegistration.jsp").forward(req, resp);
    }
}