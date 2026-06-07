<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>药品采购管理</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    function delMedicine(id) {
      if (confirm("是否删除该药品信息？")) {
        location.href = "delMedicineCharges?id=" + id;
      }
    }
  </script>
  <style type="text/css"> #main { width: 800px; margin: 0 auto; margin-top: 30px; } </style>
</head>
<body>
<div id="main">
  <div style="margin-bottom: 15px;"><a href="addMedicineCharges.jsp" class="btn btn-success">新增药品</a></div>

  <div id="findMedName">
    <form action="findMedicineChargesByName" method="post">
      <input type="text" name="medName">
      <input type="submit" value="查询">
    </form>
  </div>

  <table class="table table-hover">
    <caption>药品库存列表</caption>
    <thead>
    <tr><th>编号</th><th>药品编码</th><th>药品名称</th><th>数量</th><th>价格</th><th>操作</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${mcList}" var="m">
      <tr>
        <td>${m.id}</td>
        <td>${m.medCode}</td>
        <td>${m.medName}</td>
        <td>${m.medQuantity}</td>
        <td>${m.medPrice}</td>
        <td>
          <button class="btn btn-danger btn-sm" onclick="delMedicine(${m.id})">删除</button>
          <a href="findByMedicineCharges?id=${m.id}" class="btn btn-primary btn-sm">修改</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>