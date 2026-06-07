<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>新增诊断报告</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style type="text/css">
    #main{
      width: 400px;
      height: 500px;
      margin: 0 auto;
      margin-top: 50px;
    }
  </style>
</head>
<body>
<div id="main">
  <h3 class="text-center">新增诊断报告</h3>
  <form role="form" action="addEquipment" method="post">
    <div class="form-group">
      <label>器材编码</label>
      <input type="text" class="form-control" name="equipCode">
    </div>

    <div class="form-group">
      <label>器材名称</label>
      <input type="text" class="form-control" name="equipName">
    </div>

    <div class="form-group">
      <label>器材分类</label>
      <input type="text" class="form-control" name="equipCategory">
    </div>

    <div class="form-group">
      <label>器材数量</label>
      <input type="number" class="form-control" name="equipQuantity">
    </div>

    <input type="submit" class="btn btn-default" value="提交">
  </form>
</div>
</body>
</html>