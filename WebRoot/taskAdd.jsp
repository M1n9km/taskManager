<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>任务添加</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/servlet/TaskSearchServlet">返回</a><p>
	新增任务
	<p>
	<form
		action="${pageContext.request.contextPath}/servlet/TaskConfirmSevlet"
		method="post" name="taskConfirm" accept-charset="UTF-8">
		<%-- 任务序号：<input type="text" name="addId"><br>--%>
		任务名　：<input type="text" name="addName"><br> 
		任务描述：<textarea name="addStmt" style="width:200px;height: 80px"></textarea>
		<br>
		<button type="submit">提 交</button>
		&nbsp;
		<button type="reset">重 置</button>
	</form>
</body>
</html>