package com.neu.user.userservlet;

import com.neu.user.biz.RegistrationBiz;
import com.neu.user.biz.impl.RegistrationBizImpl;
import com.neu.user.entity.Registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findByRegistration")
public class FindByRegistrationServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            RegistrationBiz biz = new RegistrationBizImpl();
            List<Registration> list = biz.findAll();

            Registration target = null;
            for (Registration r : list) {
                if (r.getId() == id) {
                    target = r;
                    break;
                }
            }

            req.setAttribute("registration", target);
            req.getRequestDispatcher("updateRegistration.jsp").forward(req, resp);
        }
    }
}