package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.UserDaoImpl;
import com.taskmanager.dao.impl.UserTaskDaoImpl;
import com.taskmanager.entity.UserTask;
import com.taskmanager.tool.Check;
/**
 * 已接任务界面
 * @author controller
 *
 */
public class RecTskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			String id = session.getAttribute("id").toString();
			UserTaskDaoImpl userTaskDaoImpl = new UserTaskDaoImpl();
			UserTask userTask;
			if (userDaoImpl.findById(id) == null) {
				Check.message(request, response, "对不起，此用户不存在，请重新登录，2秒后为您跳转到登录页面",
						"/servlet/LoginUIServlet");
			}
			userTask = userTaskDaoImpl.find(id);
			request.setAttribute("taskList", userTask.getTaskList());
			request.setAttribute("userName", userDaoImpl.findById(id).getName());
			request.getRequestDispatcher("/recTsk.jsp").forward(request,
					response);
		} catch (Exception e) {
			Check.message(request, response, "对不起，连接超时，请重新登录，2秒后为您跳转到登录页面", "/servlet/LoginUIServlet");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
