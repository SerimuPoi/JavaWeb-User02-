package com.neu.user.userservlet;

import com.neu.user.biz.SchedulingBiz;
import com.neu.user.biz.impl.SchedulingBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delScheduling")
public class DelSchedulingServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            SchedulingBiz biz = new SchedulingBizImpl();
            boolean isSuccess = biz.deleteScheduling(id);

            if (isSuccess) {
                resp.sendRedirect("findScheduling");
            } else {
                resp.setContentType("text/html;charset=UTF-8");
                resp.getWriter().print("<script>alert('删除失败！');history.back();</script>");
            }
        }
    }
}