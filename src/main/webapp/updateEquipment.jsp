<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>修改器材</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <style type="text/css"> #main{ width: 400px; margin: 0 auto; margin-top: 50px; } </style>
</head>
<body>
<div id="main">
  <form role="form" action="updateEquipment" method="post">
    <input type="hidden" name="id" value="${equipment.id}">

    <div class="form-group">
      <label>编码</label>
      <input type="text" class="form-control" name="equipCode" value="${equipment.equipCode}">
    </div>

    <div class="form-group">
      <label>名称</label>
      <input type="text" class="form-control" name="equipName" value="${equipment.equipName}">
    </div>

    <div class="form-group">
      <label>分类</label>
      <input type="text" class="form-control" name="equipCategory" value="${equipment.equipCategory}">
    </div>

    <div class="form-group">
      label>数量</label>
      <input type="text" class="form-control" name="equipQuantity" value="${equipment.equipQuantity}">
    </div>

    <button type="submit" class="btn btn-default">提交</button>
  </form>
</div>
</body>
</html>