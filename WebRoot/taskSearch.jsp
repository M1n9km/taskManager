<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<title>任务信息</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/servlet/AdmEntServlet">返回</a><p>
	任务信息
	<p>
	<c:import url="taskShow.jsp" charEncoding="utf-8"></c:import>
	<a href="${pageContext.request.contextPath}/servlet/TaskAddServlet">新增</a>
</body>
</html>