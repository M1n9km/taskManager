<%@page import="com.taskmanager.entity.Task"%>
<%@page import="com.taskmanager.entity.UserTask"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<c:if test="${tasks!=null }">
	<c:if test="${tasks[0]!=nill }">
		<c:forEach items="${tasks}" var="task">
			<tr>
				<td>${task.tskId }</td>
				<td>${task.tskName }</td>
				<td>${task.tskStmt }</td>
				<td><a
					href="${pageContext.request.contextPath}/servlet/GetTaskServlet?tid=${task.tskId}"
					onclick="window.location.reload()">领 取</a>
			</tr>
		</c:forEach>
	</c:if>
</c:if>

