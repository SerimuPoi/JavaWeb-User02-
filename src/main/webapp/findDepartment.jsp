<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>科室信息</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    function delDepartment(id) {
      if (confirm("是否删除该科室？")) {
        location.href = "delDepartment?id=" + id;
      }
    }

    function findByDepartment(id){
      // 跳转到专门用于回显数据的Servlet（您需要在后台补充这个Servlet）
      location.href = "findByDepartment?id=" + id;
    }
  </script>

  <style type="text/css">
    #main {
      width: 800px; /* 列表稍微放宽一点以容纳更多列 */
      margin: 0 auto;
      margin-top: 30px;
    }
  </style>
</head>
<body>

<div id="main">
  <div style="margin-bottom: 15px;">
    <a href="addDepartment.jsp" class="btn btn-success">新增科室</a>
  </div>

  <table class="table table-hover">
    <caption>科室列表</caption>
    <thead>
    <tr>
      <th>编号</th>
      <th>科室编码</th>
      <th>科室名称</th>
      <th>科室分类</th>
      <th>科室类别</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${deptList}" var="dept">
      <tr>
        <td>${dept.id}</td>
        <td>${dept.deptCode}</td>
        <td>${dept.deptName}</td>
        <td>${dept.deptCategory}</td>
        <td>${dept.deptType}</td>
        <td>
          <button type="button" class="btn btn-danger btn-sm" onclick="delDepartment(${dept.id})">删除</button>
          <button type="button" class="btn btn-primary btn-sm" onclick="findByDepartment(${dept.id})">修改</button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>