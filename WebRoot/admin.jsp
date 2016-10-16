<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>管理员页面</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/servlet/ReturnToIndexServlet">返回</a><p>
<table>
	<tr>
	<td><a href="${pageContext.request.contextPath}/servlet/SearchUserServlet">用户信息</a></td>
	</tr>
	<tr>
	<td><a href="${pageContext.request.contextPath}/servlet/TaskSearchServlet">任务信息</a></td>
	</tr>
	<tr><td><a href="${pageContext.request.contextPath}/servlet/CreateUserServlet">新建用户</a></td></tr>
	</table>
</body>
</html>