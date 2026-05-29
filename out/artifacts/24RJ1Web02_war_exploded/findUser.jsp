<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 28/5/2026
  Time: 下午5:36
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
    <script src="js/jquery.js"></script>
    <script>
        function delUser(id) {
            if (confirm("是否删除")) {
                location.href = "delUser?id=" + id;
            }
        }

        function findByUser(id){
        alert(id);
        location.href="findUser?id"+id;
        }
    </script>


    <style type="text/css">
        #main {
            width: 400px;
            height: 500px;
            margin: 0 auto;
    }
  </style>
</head>
<body>
<p class="name">
  ${user.uname}登录成功
</p>

<div id="main">
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
    <c:forEach items="${list}" var="user">
    <tr>
      <td>${user.id}</td>
      <td>${user.uname}</td>
      <td>${user.upwd}</td>
      <td>${user.type}</td>
      <td>
        <button type="button" class="btn btn-primary" onclick="delUser(${user.id})">删除</button>
      </td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
