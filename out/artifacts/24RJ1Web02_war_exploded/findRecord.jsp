<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>病历管理</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    function delRecord(id) {
      if (confirm("是否删除该病历？")) {
        location.href = "delRecord?id=" + id;
      }
    }
  </script>
  <style type="text/css"> #main { width: 800px; margin: 0 auto; margin-top: 30px; } </style>
</head>
<body>
<div id="main">
  <div style="margin-bottom: 15px;"><a href="addRecord.jsp" class="btn btn-success">新增病历</a></div>
  <table class="table table-hover">
    <caption>病历信息列表</caption>
    <thead>
    <tr><th>编号</th><th>病历编码</th><th>病历日期</th><th>病人姓名</th><th>操作</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${recordList}" var="r">
      <tr>
        <td>${r.id}</td>
        <td>${r.recordCode}</td>
        <td>${r.recordDate}</td>
        <td>${r.patientName}</td>
        <td>
          <button class="btn btn-danger btn-sm" onclick="delRecord(${r.id})">删除</button>
          <a href="findByRecord?id=${r.id}" class="btn btn-primary btn-sm">修改</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>