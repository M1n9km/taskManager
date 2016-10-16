package com.taskmanager.controller;

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
 * 用户信息搜索处理
 * 
 * @author controller
 *
 */
public class SearchUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Check.checkAdmin(request, response);
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			String searchInput = request.getSession().getAttribute("id")
					.toString();
			if (request.getParameter("searchInput") != null)
				searchInput = request.getParameter("searchInput").toString();
			int sum = userDaoImpl.getSum(searchInput);
			int page = 1;
			if (request.getParameter("page") != null)
				page = Integer.parseInt(request.getParameter("page"));
			ArrayList<User> users;
			if (searchInput.equals("all"))
				users = userDaoImpl.searchAllLimit(page);
			else
				users = userDaoImpl.searchLimit(page, searchInput);
			String errorS = "对不起，查无此人，请重新输入,2秒后自动返回";
			if (users==null) {
				Check.message(request, response, errorS, "/servlet/SearchUserServlet");
			}
			request.setAttribute("users", users);
			request.setAttribute("page", page);
			request.setAttribute("sum", sum);
			request.setAttribute("searchInput", searchInput);
			request.getRequestDispatcher("/infoSearch.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
			String errorS = "对不起，查无此人，请重新输入,2秒后自动返回";
			Check.message(request, response, errorS, "/servlet/SearchUserServlet");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
