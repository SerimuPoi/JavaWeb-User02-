<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>挂号管理</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    function delRegistration(id) {
      if (confirm("是否删除该挂号信息？")) {
        location.href = "delRegistration?id=" + id;
      }
    }
  </script>
  <style type="text/css"> #main { width: 800px; margin: 0 auto; margin-top: 30px; } </style>
</head>
<body>
<div id="main">
  <div style="margin-bottom: 15px;"><a href="addRegistration.jsp" class="btn btn-success">新增挂号类型</a></div>
  <table class="table table-hover">
    <caption>挂号类型列表</caption>
    <thead>
    <tr><th>编号</th><th>号别编码</th><th>号别名称</th><th>显示顺序号</th><th>挂号费</th><th>操作</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${regList}" var="r">
      <tr>
        <td>${r.id}</td>
        <td>${r.regCode}</td>
        <td>${r.regName}</td>
        <td>${r.displayOrder}</td>
        <td>${r.regFee}</td>
        <td>
          <button class="btn btn-danger btn-sm" onclick="delRegistration(${r.id})">删除</button>
          <a href="findByRegistration?id=${r.id}" class="btn btn-primary btn-sm">修改</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>