<%@page import="com.taskmanager.entity.Task"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE >
<html>
<head>
<title>展示任务列表</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>任务序号</th>
			<th>任务名</th>
			<th>任务描述</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:if test="${tasks!=null }">
			<c:if test="${tasks[0]!=null }">
				<c:forEach items="${tasks }" var="task">
					<tr>
						<td>${task.tskId }</td>
						<td>${task.tskName }</td>
						<td>${task.tskStmt }</td>
						<td><a
							href="${pageContext.request.contextPath}/servlet/TaskModifyServlet?taskId=${task.tskId }"
							onclick="window.location.reload">修改</a>
						<td><a
							href="${pageContext.request.contextPath}/servlet/TaskDeleteServlet?taskId=${task.tskId }"
							onclick="window.location.reload">删除</a>
					</tr>
				</c:forEach>
			</c:if>
		</c:if>
		<!--  <
			ArrayList<Task> tasks = (ArrayList<Task>) request
					.getAttribute("tasks");
			if (tasks.size()==0)
				;
			else if (tasks.get(0) == null)
				;
			else
				for (int i = 0; i < tasks.size(); i++) {
					Task task = tasks.get(i);
					String tid = task.getTskId();
					String name = task.getTskName();
					String stmt = task.getTskStmt();
		>
		<tr>
			<td><=tid></td>
			<td><=name></td>
			<td><=stmt></td>
			<td><a
				href="${pageContext.request.contextPath}/servlet/TaskModifyServlet?taskId=<=tid>"
				onclick="window.location.reload">修改</a>
			<td><a
				href="${pageContext.request.contextPath}/servlet/TaskDeleteServlet?taskId=<=tid>"
				onclick="window.location.reload">删除</a>
		</tr>

		<
			}
		>
		-->
	</table>
</body>
</html>