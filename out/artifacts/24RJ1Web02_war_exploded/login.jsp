<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 28/5/2026
  Time: 上午9:16
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
    <form class="form-horizontal" role="form" action="login" method="post">

      <div class="form-group">
        <label for="uname" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="uname" name="uname" placeholder="请输入姓名">
        </div>
      </div>

      <div class="form-group">
        <label for="upwd" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="upwd" name="upwd" placeholder="请输入密码">
        </div>
      </div>

      <input type="submit" class="btn btn-default" value="提交">

    </form>
  </div>
  </body>
</html>
