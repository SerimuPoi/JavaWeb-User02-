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
import java.math.BigDecimal;

@WebServlet("/addRegistration")
public class AddRegistrationServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 1. 获取参数
        String regCode = req.getParameter("regCode");
        String regName = req.getParameter("regName");
        String displayOrderStr = req.getParameter("displayOrder");
        String regFeeStr = req.getParameter("regFee");

        // 2. 封装对象
        Registration reg = new Registration();
        reg.setRegCode(regCode);
        reg.setRegName(regName);

        if (displayOrderStr != null && !displayOrderStr.isEmpty()) {
            reg.setDisplayOrder(Integer.parseInt(displayOrderStr));
        }
        if (regFeeStr != null && !regFeeStr.isEmpty()) {
            reg.setRegFee(new Integer(regFeeStr));
        }

        // 3. 业务层处理
        RegistrationBiz biz = new RegistrationBizImpl();
        boolean isSuccess = biz.addRegistration(reg);

        // 4. 响应
        if (isSuccess) {
            resp.sendRedirect("findRegistration");
        } else {
            resp.getWriter().print("<script>alert('添加失败！');history.back();</script>");
        }
    }
}