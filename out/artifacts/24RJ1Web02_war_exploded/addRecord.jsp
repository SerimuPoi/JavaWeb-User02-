<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>新增病历</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <style type="text/css"> #main{ width: 400px; margin: 0 auto; margin-top: 50px; } </style>
</head>
<body>
<div id="main">
  <form role="form" action="addRecord" method="post">
    <div class="form-group">
      <label>病历编码</label>
      <input type="text" class="form-control" name="recordCode">
    </div>
    <div class="form-group">
      <label>病历日期</label>
      <input type="text" class="form-control" name="recordDate">
    </div>
    <div class="form-group">
      <label>病人姓名</label>
      <input type="text" class="form-control" name="patientName">
    </div>
    <button type="submit" class="btn btn-default">提交</button>
  </form>
</div>
</body>
</html>