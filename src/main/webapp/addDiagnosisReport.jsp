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
    <form role="form" action="addDiagnosisReport" method="post">

        <div class="form-group">
            <label for="diseaseCode">疾病编码</label>
            <input type="text" class="form-control" id="diseaseCode" name="diseaseCode" placeholder="请输入疾病编码">
        </div>

        <div class="form-group">
            <label for="diseaseName">疾病名称</label>
            <input type="text" class="form-control" id="diseaseName" name="diseaseName" placeholder="请输入疾病名称">
        </div>

        <div class="form-group">
            <label for="icdCode">ICD编码</label>
            <input type="text" class="form-control" id="icdCode" name="icdCode" placeholder="请输入ICD编码">
        </div>

        <div class="form-group">
            <label for="diseaseCategory">疾病所属分类</label>
            <input type="text" class="form-control" id="diseaseCategory" name="diseaseCategory" placeholder="请输入分类">
        </div>

        <button type="submit" class="btn btn-success btn-block">提交</button>

    </form>
</div>
</body>
</html>