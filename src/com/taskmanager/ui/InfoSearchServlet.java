package com.taskmanager.ui;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.impl.UserDaoImpl;
import com.taskmanager.entity.User;
import com.taskmanager.tool.Check;
/**
 * 进入个人信息搜索界面
 * @author controller
 *
 */
public class InfoSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Check.checkAdmin(request, response);
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		ArrayList<User> users = new ArrayList<User>();
		users.add(userDaoImpl.findById(request.getSession().getAttribute("id")
				.toString()));
		request.setAttribute("users", users);
		request.getRequestDispatcher("/infoSearch.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
