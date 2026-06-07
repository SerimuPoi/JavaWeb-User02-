<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>修改科室</title>
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
  <h3 class="text-center">修改科室信息</h3>
  <form role="form" action="updateDepartment" method="post">
    <input type="hidden" name="id" value="${department.id}">

    <div class="form-group">
      <label for="deptCode">科室编码</label>
      <input type="text" class="form-control" id="deptCode" name="deptCode" placeholder="请输入科室编码" value="${department.deptCode}">
    </div>

    <div class="form-group">
      <label for="deptName">科室名称</label>
      <input type="text" class="form-control" id="deptName" name="deptName" placeholder="请输入科室名称" value="${department.deptName}">
    </div>

    <div class="form-group">
      <label for="deptCategory">科室分类</label>
      <input type="text" class="form-control" id="deptCategory" name="deptCategory" placeholder="请输入科室分类" value="${department.deptCategory}">
    </div>

    <div class="form-group">
      <label for="deptType">科室类别</label>
      <input type="text" class="form-control" id="deptType" name="deptType" placeholder="请输入科室类别" value="${department.deptType}">
    </div>

    <button type="submit" class="btn btn-primary btn-block">保存修改</button>

  </form>
</div>

</body>
</html>