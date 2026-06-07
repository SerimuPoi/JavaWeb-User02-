<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>修改药品</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <style type="text/css"> #main{ width: 400px; margin: 0 auto; margin-top: 50px; } </style>
</head>
<body>
<div id="main">
  <form role="form" action="updateMedicineCharges" method="post">
    <input type="hidden" name="id" value="${medicineCharges.id}">

    <div class="form-group">
      <label>药品编码</label>
      <input type="text" class="form-control" name="medCode" value="${medicineCharges.medCode}">
    </div>

    <div class="form-group">
      <label>药品名称</label>
      <input type="text" class="form-control" name="medName" value="${medicineCharges.medName}">
    </div>

    <div class="form-group">
      <label>数量</label>
      <input type="text" class="form-control" name="medQuantity" value="${medicineCharges.medQuantity}">
    </div>

    <div class="form-group">
      <label>价格</label>
      <input type="text" class="form-control" name="medPrice" value="${medicineCharges.medPrice}">
    </div>

    <button type="submit" class="btn btn-default">提交</button>
  </form>
</div>
</body>
</html>