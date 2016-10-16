<%@page import="com.taskmanager.entity.Task"%>
<%@page import="com.taskmanager.entity.UserTask"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<c:if test="${taskList!=null}">
	<c:if test="${taskList[0]!=null }">
		<c:forEach items="${taskList }" var="task">
			<tr>
				<td>${task.tskId }</td>
				<td>${task.tskName }</td>
				<td>${task.tskStmt }</td>
				<td><a
					href="${pageContext.request.contextPath}/servlet/TaskCancelServlet?tid=${task.tskId}"
					onclick="window.location.reload()">取消任务</a></td>
			</tr>
		</c:forEach>
	</c:if>
</c:if>
<!--  
	ArrayList<Task> list = (ArrayList<Task>) request
			.getAttribute("taskList");
	if (list.size()==0)
		;
	else if (list.get(0)==null)
		;
	else
		for (int i = 0; i < list.size(); i++) {
			Task task = list.get(i);
			String id = task.getTskId();
			String name = task.getTskName();
			String stmt = task.getTskStmt();
%>
<tr>
	<td><=id%></td>
	<td><=name%></td>
	<td><=stmt%></td>
	<td><a
		href="${pageContext.request.contextPath}/servlet/TaskCancelServlet?tid=<=id%>"
		onclick="window.location.reload()">取消任务</a></td>
</tr>
<
	}
>

-->
