<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>诊断报告信息</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    function delDiagnosisReport(id) {
      if (confirm("是否删除该诊断报告？")) {
        location.href = "delDiagnosisReport?id=" + id;
      }
    }

    function findByDiagnosisReport(id){
      location.href = "findByDiagnosisReport?id=" + id;
    }
  </script>

  <style type="text/css">
    #main {
      width: 800px;
      margin: 0 auto;
      margin-top: 30px;
    }
  </style>
</head>
<body>

<div id="main">
  <div style="margin-bottom: 15px;">
    <a href="addDiagnosisReport.jsp" class="btn btn-success">新增诊断报告</a>
  </div>

  <div id="findDiseaseName">
    <form action="findDiagnosisReportByName" method="post">
      <input type="text" name="diseaseName">
      <input type="submit" value="查询">
    </form>
  </div>

  <table class="table table-hover">
    <caption>诊断报告列表</caption>
    <thead>
    <tr>
      <th>编号</th>
      <th>疾病编码</th>
      <th>疾病名称</th>
      <th>ICD编码</th>
      <th>疾病所属分类</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reportList}" var="report">
      <tr>
        <td>${report.id}</td>
        <td>${report.diseaseCode}</td>
        <td>${report.diseaseName}</td>
        <td>${report.icdCode}</td>
        <td>${report.diseaseCategory}</td>
        <td>
          <button type="button" class="btn btn-danger btn-sm" onclick="delDiagnosisReport(${report.id})">删除</button>
          <button type="button" class="btn btn-primary btn-sm" onclick="findByDiagnosisReport(${report.id})">修改</button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>