package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.LoginDaoImpl;
import com.taskmanager.dao.impl.UserDaoImpl;
import com.taskmanager.entity.Login;
import com.taskmanager.entity.User;
import com.taskmanager.tool.Check;
import com.taskmanager.util.MD5.MD5Util;

/**
 * 处理用户的login请求
 * 
 * @author controller
 *
 */

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		String password = request.getParameter("password");// 获取登录信息
		LoginDaoImpl loginDao = new LoginDaoImpl();
		Login login = loginDao.find(id, MD5Util.ecodeByMD5(password));// 检验登录信息
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.findById(id);
		if (login == null) {
			Check.message(request, response, "对不起，用户名或密码有误，请重新登录，2秒后为您跳转到登录页面", "/servlet/LoginUIServlet");
		}
		String role=login.getRole();
		session.setAttribute("id", id);
		session.setAttribute("role", role);
		String message = String.format("恭喜：%s,登陆成功！本页将在2秒后跳到首页！！"
				+ "<meta http-equiv='refresh' content='2;url=%s'",
				user.getName(), request.getContextPath() + "/servlet/ReturnToIndexServlet");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
