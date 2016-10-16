package com.taskmanager.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.UserDaoImpl;
import com.taskmanager.entity.User;
import com.taskmanager.tool.Check;
/**
 * 个人信息页面
 * @author controller
 *
 */
public class PerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session=request.getSession(true);
			UserDaoImpl userDaoImpl=new UserDaoImpl();
			User user=userDaoImpl.findById(session.getAttribute("id").toString());
			request.setAttribute("user", user);
			request.getRequestDispatcher("/perInfo.jsp").forward(request, response);
		} catch (Exception e) {
			Check.message(request, response, "对不起，连接超时，请重新登录，2秒后为您跳转到登录页面", "/servlet/LoginUIServlet");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
