package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.impl.LoginDaoImpl;
import com.taskmanager.dao.impl.UserDaoImpl;
import com.taskmanager.entity.Login;
import com.taskmanager.entity.User;
import com.taskmanager.tool.Check;
import com.taskmanager.util.MD5.MD5Util;

public class CreateConfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("uName").toString();
		String college=request.getParameter("uCollege").toString();
		String clas=request.getParameter("uClas").toString();
		String major=request.getParameter("uMajor").toString();
		String mail=request.getParameter("uMail").toString();
		String direction=request.getParameter("uDirection").toString();
		String password=MD5Util.ecodeByMD5(request.getParameter("uPassword").toString());
		String role=request.getParameter("uRole").toString();
		User user=new User(name,college,clas,major,mail,direction);
		Login login=new Login(password,role);
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		LoginDaoImpl loginDaoImpl=new LoginDaoImpl();
		loginDaoImpl.add(login);
		String uId=login.getId();
		userDaoImpl.add(user);
		user=userDaoImpl.findByName(name);
		Check.messageNotRt(request, response,"<a href='./CreateUserServlet'>返回</a><p>", "用户  "+user.getName()+"  新建成功！该用户的账号为:"+uId+"  请记住用户账号并自行返回。");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
