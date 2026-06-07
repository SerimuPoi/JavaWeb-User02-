<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>处方管理</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    function delPrescription(id) {
      if (confirm("是否删除该处方？")) {
        location.href = "delPrescription?id=" + id;
      }
    }
  </script>
  <style type="text/css"> #main { width: 800px; margin: 0 auto; margin-top: 30px; } </style>
</head>
<body>
<div id="main">
  <div style="margin-bottom: 15px;"><a href="addPrescription.jsp" class="btn btn-success">新增处方</a></div>

  <div id="findPatientName">
    <form action="findPrescriptionByName" method="post">
      <input type="text" name="patientName"">
      <input type="submit" value="查询">
    </form>
  </div>

  <table class="table table-hover">
    <caption>处方信息列表</caption>
    <thead>
    <tr><th>编号</th><th>处方编号</th><th>处方日期</th><th>病人姓名</th><th>费用</th><th>操作</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${presList}" var="p">
      <tr>
        <td>${p.id}</td>
        <td>${p.presCode}</td>
        <td>${p.presDate}</td>
        <td>${p.patientName}</td>
        <td>${p.presFee}</td>
        <td>
          <button class="btn btn-danger btn-sm" onclick="delPrescription(${p.id})">删除</button>
          <a href="findByPrescription?id=${p.id}" class="btn btn-primary btn-sm">修改</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>