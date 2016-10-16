<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<title>用户信息查询</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/servlet/AdmEntServlet">返回</a><p>
	<form name="searchUser"
		action="${pageContext.request.contextPath}/servlet/SearchUserServlet"
		method="post">
		输入用户id或昵称(输入"all"搜索所有用户)<input type="text" name="searchInput">
		<input type="submit" value="查找" onclick="window.location.reload()">
	</form>
	<div id="perInfo">
	<c:import url="perInfoM.jsp" charEncoding="urf-8"></c:import>
</div>
</body>
</html>