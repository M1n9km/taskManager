<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

<title>登录页面</title>
</head>

<body>
	<div align="center">
		<h1>任务管理系统</h1>
		<p>
		<h1>登录</h1>

		<p>
		<form method="post"
			action="${pageContext.request.contextPath}/servlet/LoginServlet"
			name="login">
			<table>
				<tr>
					<td>账号：</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<p />
			<input type="submit" value="登录"> <input type="reset"
				value="重置">
		</form>
	</div>
</body>
</html>
