<%@page import="java.util.ArrayList"%>
<%@page import="com.taskmanager.entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<c:forEach var="pageSt" begin="1" end="${sum }" step="1">
	<a
		href="${pageContext.request.contextPath}/servlet/SearchUserServlet?page=${pageSt}
		&searchInput=${searchInput}">${pageSt}</a>
</c:forEach>

<c:if test="${users!=null }">
	<c:if test="${users[0]!=null }">
		<c:forEach items="${users}" var="user">
			<table border=1>
				<tr>
					<td>账号：</td>
					<td><c:out value="${user.id}"></c:out></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><c:out value="${user.name}"></c:out></td>
				</tr>
				<tr>
					<td>学院：</td>
					<td><c:out value="${user.college}"></c:out></td>
				</tr>
				<tr>
					<td>班级：</td>
					<td><c:out value="${user.clas}"></c:out></td>
				</tr>
				<tr>
					<td>专业：</td>
					<td><c:out value="${user.major}"></c:out></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><c:out value="${user.mail}"></c:out></td>
				</tr>
				<tr>
					<td>方向：</td>
					<td><c:out value="${user.direction}"></c:out></td>
				</tr>
			</table>
			<p>
		</c:forEach>
	</c:if>
</c:if>
<!--  <--//for(int pag=1;pag<=(Integer)request.getAttribute("sum");pag++){
			//request.setAttribute("pageSt", pag);
			//--%>
<}>
-->
<!--  <
	if (request.getAttribute("users").equals(null))
		;
	else {
		ArrayList<User> users = (ArrayList<User>) request
				.getAttribute("users");
		if (users.equals(null) || users.get(0).equals(null))
			;
		else
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				String id = user.getId();
				String name = user.getName();
				String college = user.getCollege();
				String clas = user.getClas();
				String major = user.getMajor();
				String mail = user.getMail();
				String direction = user.getDirection();
>
<table border=1>
	<tr>
		<td>账号：</td>
		<td><=id></td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td><=name></td>
	</tr>
	<tr>
		<td>学院：</td>
		<td><=college></td>
	</tr>
	<tr>
		<td>班级：</td>
		<td><=clas></td>
	</tr>
	<tr>
		<td>专业：</td>
		<td><=major></td>
	</tr>
	<tr>
		<td>邮箱：</td>
		<td><=mail></td>
	</tr>
	<tr>
		<td>方向：</td>
		<td><=direction></td>
	</tr>
</table>
<p>
	<
		}
		}
	>-->