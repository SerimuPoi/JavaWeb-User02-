<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2/6/2026
  Time: 上午10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style type="text/css">
    #main {
      width: 400px;
      height: 500px;
      margin: 0 auto;
    }
  </style>
</head>
<body>
<div id="main">
  <div id="findUserName">
    <form action="findByUserName.jsp" method="post">
      <input type="text" name="uname">
      <input type="submit" value="查询">
    </form>
  </div>
  <table class="table table-hover">
    <caption>用户信息</caption>
    <thead>
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>密码</th>
      <th>类型</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
      <tr>
        <td>${u.id}</td>
        <td>${u.uname}</td>
        <td>${u.upwd}</td>
        <td>${u.type}</td>
        <td>
          <button type="button" class="btn btn-primary" onclick="delUser(${u.id})">删除</button>
          <button type="button" class="btn btn-primary" onclick="findByUser(${u.id})">修改</button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
