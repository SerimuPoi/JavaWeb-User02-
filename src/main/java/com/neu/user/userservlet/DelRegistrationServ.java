package com.neu.user.userservlet;

import com.neu.user.biz.RegistrationBiz;
import com.neu.user.biz.impl.RegistrationBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delRegistration")
public class DelRegistrationServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            RegistrationBiz biz = new RegistrationBizImpl();
            boolean isSuccess = biz.deleteRegistration(id);

            if (isSuccess) {
                resp.sendRedirect("findRegistration");
            } else {
                resp.setContentType("text/html;charset=UTF-8");
                resp.getWriter().print("<script>alert('删除失败！');history.back();</script>");
            }
        }
    }
}