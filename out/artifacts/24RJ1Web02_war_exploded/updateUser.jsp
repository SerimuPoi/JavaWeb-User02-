<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 1/6/2026
  Time: 下午2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
    #main{
      width: 400px;
      height: 500px;
      margin: 0 auto;
    }
  </style>

</head>
<body>

<div id="main">
    <form role="form" action="updateUser" method="post">

        <div class="form-group">
            <label for="id"></label>
            <input type="hidden" class="form-control" id="id" name="id"
                   placeholder="请输入编号" value="${user.id}">
        </div>

        <div class="form-group">
            <label for="uname">姓名</label>
            <input type="text" class="form-control" id="uname" name="uname"
                   placeholder="请输入姓名" value="${user.uname}">
        </div>

        <div class="form-group">
            <label for="upwd">密码</label>
            <input type="text" class="form-control" id="upwd" name="upwd"
                   placeholder="请输入密码" value="${user.upwd}">
        </div>

        <div class="form-group">
            <label for="type">类型</label>
            <input type="text" class="form-control" id="type" name="type"
                   placeholder="请输入类型" value="${user.type}">
        </div>

        <input type="submit" class="btn btn-default" value="提交">

    </form>
</div>

</body>
</html>
