<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>修改挂号</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <style type="text/css"> #main{ width: 400px; margin: 0 auto; margin-top: 50px; } </style>
</head>
<body>
<div id="main">
  <form role="form" action="updateRegistration" method="post">
    <input type="hidden" name="id" value="${registration.id}">

    <div class="form-group">
      <label>号别编码</label>
      <input type="text" class="form-control" name="regCode" value="${registration.regCode}">
    </div>
    <div class="form-group">
      <label>号别名称</label>
      <input type="text" class="form-control" name="regName" value="${registration.regName}">
    </div>
    <div class="form-group">
      <label>显示顺序号</label>
      <input type="text" class="form-control" name="displayOrder" value="${registration.displayOrder}">
    </div>
    <div class="form-group">
      <label>挂号费</label>
      <input type="text" class="form-control" name="regFee" value="${registration.regFee}">
    </div>
    <button type="submit" class="btn btn-default">提交</button>
  </form>
</div>
</body>
</html>