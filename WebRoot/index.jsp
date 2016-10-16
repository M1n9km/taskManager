<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>任务管理系统</title>

</head>

<body>
	<a href="${pageContext.request.contextPath}/servlet/LogOutServlet">注销</a>
	<p>
	<table>
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/servlet/PerInfoServlet">个人信息查询</a></td>
		</tr>
		<C:if test="${sessionScope.role=='user'}">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/servlet/RecTskServlet">已接任务查询</a></td>
			</tr>
		</C:if>
		<C:if test="${sessionScope.role=='admin'}">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/servlet/AdmEntServlet">管理员入口</a></td>
			</tr>
		</C:if>
	</table>
	<C:if test="${sessionScope.role=='user'}">
	<p>可领取任务：
	<table border="1">
		<tr>
			<th>任务序号</th>
			<th>任务名</th>
			<th>任务描述</th>
			<th>领取任务</th>
		</tr>
		<C:import url="./indexTask.jsp" charEncoding="utf-8"></C:import>
	</table>
	</C:if>
</body>
</html>
