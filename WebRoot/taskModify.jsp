<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>任务修改</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/servlet/TaskSearchServlet">返回</a><p>
信息修改<p>
<form method="post" action="${pageContext.request.contextPath}/servlet/ModifyConfirmServlet" accept-charset="UTF-8">
任务序号：<input type="text" name="tid" value="${task.tskId}"  readonly="readonly"><br>
任务名　：<input type="text" name="name" value="${task.tskName}"><br>
任务描述：<textarea name="stmt" style="widows: 170px;heigt:200px;">${task.tskStmt}</textarea><br>
<button type="submit">提交</button>
</form>
</body>
</html>