<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>修改排班</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <style type="text/css"> #main{ width: 400px; margin: 0 auto; margin-top: 50px; } </style>
</head>
<body>
<div id="main">
    <form role="form" action="updateScheduling" method="post">
        <input type="hidden" name="id" value="${scheduling.id}">

        <div class="form-group">
            <label>医生ID</label>
            <input type="text" class="form-control" name="doctorId" value="${scheduling.doctorId}">
        </div>
        <div class="form-group">
            <label>医生姓名</label>
            <input type="text" class="form-control" name="doctorName" value="${scheduling.doctorName}">
        </div>
        <div class="form-group">
            <label>医生类型</label>
            <input type="text" class="form-control" name="doctorType" value="${scheduling.doctorType}">
        </div>
        <div class="form-group">
            <label>排班日期</label>
            <input type="text" class="form-control" name="scheduleDate" value="${scheduling.scheduleDate}">
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>
</body>
</html>