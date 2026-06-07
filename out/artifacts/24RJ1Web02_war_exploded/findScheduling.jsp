<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>排班管理</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    function delScheduling(id) {
      if (confirm("是否删除该排班？")) {
        location.href = "delScheduling?id=" + id;
      }
    }
  </script>
  <style type="text/css"> #main { width: 800px; margin: 0 auto; margin-top: 30px; } </style>
</head>
<body>
<div id="main">
  <div style="margin-bottom: 15px;"><a href="addScheduling.jsp" class="btn btn-success">新增排班</a></div>
  <table class="table table-hover">
    <caption>医生排班列表</caption>
    <thead>
    <tr><th>编号</th><th>医生ID</th><th>医生姓名</th><th>医生类型</th><th>排班日期</th><th>操作</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${schedList}" var="s">
      <tr>
        <td>${s.id}</td>
        <td>${s.doctorId}</td>
        <td>${s.doctorName}</td>
        <td>${s.doctorType}</td>
        <td>${s.scheduleDate}</td>
        <td>
          <button class="btn btn-danger btn-sm" onclick="delScheduling(${s.id})">删除</button>
          <a href="findByScheduling?id=${s.id}" class="btn btn-primary btn-sm">修改</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>