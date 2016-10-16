<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>已接任务</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/servlet/ReturnToIndexServlet">返回</a><p>
<table border="1">
<caption>${userName} 的已接任务</caption>
<tr>
<th>任务序号</th>
<th>任务名</th>
<th>任务描述</th>
<th>取消任务</th>
</tr>
<c:import url="taskTable.jsp" charEncoding="utf-8"></c:import>
</table>
</body>
</html>