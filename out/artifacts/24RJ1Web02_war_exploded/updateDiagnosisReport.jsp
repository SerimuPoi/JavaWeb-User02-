<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
  <title>修改诊断报告</title>
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
  <h3 class="text-center">修改诊断报告</h3>
  <form role="form" action="updateDiagnosisReport" method="post">
    <input type="hidden" name="id" value="${report.id}">

    <div class="form-group">
      <label for="diseaseCode">疾病编码</label>
      <input type="text" class="form-control" id="diseaseCode" name="diseaseCode" placeholder="请输入疾病编码" value="${report.diseaseCode}">
    </div>

    <div class="form-group">
      <label for="diseaseName">疾病名称</label>
      <input type="text" class="form-control" id="diseaseName" name="diseaseName" placeholder="请输入疾病名称" value="${report.diseaseName}">
    </div>

    <div class="form-group">
      <label for="icdCode">ICD编码</label>
      <input type="text" class="form-control" id="icdCode" name="icdCode" placeholder="请输入ICD编码" value="${report.icdCode}">
    </div>

    <div class="form-group">
      <label for="diseaseCategory">疾病所属分类</label>
      <input type="text" class="form-control" id="diseaseCategory" name="diseaseCategory" placeholder="请输入分类" value="${report.diseaseCategory}">
    </div>

    <button type="submit" class="btn btn-primary btn-block">保存修改</button>

  </form>
</div>

</body>
</html>