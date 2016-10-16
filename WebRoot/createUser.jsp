<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>新建用户</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/servlet/AdmEntServlet">返回</a><p>
<form name="createUser" method="post" action="${pageContext.request.contextPath}/servlet/CreateConfirmServlet">
<table>
<tr>
<td>姓名：<input type="text" name="uName"></td>
</tr>
<tr>
<td>学院：<input type="text" name="uCollege"></td>
</tr>
<tr>
<td>班级：<input type="text" name="uClas"></td>
</tr>
<tr>
<td>专业：<input type="text" name="uMajor"></td>
</tr>
<tr>
<td>邮箱：<input type="text" name="uMail"></td>
</tr>
<tr>
<td>方向：<input type="text" name="uDirection"></td>
</tr>
<tr>
<td>密码：<input type="password" name="uPassword"></td>
</tr>
<tr>
<td>角色：  
<select name="uRole">
<option value="user">用户</option>
<option value="admin">管理员</option>
</select></td>
</tr>
<tr>
<td><input type="submit"></td>
<td><input type="reset"></td>
</tr>
</table>
</form>
</body>
</html>