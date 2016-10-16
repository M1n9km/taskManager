package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.UserTaskDaoImpl;
/**
 * 处理取消任务
 * @author controller
 *
 */
public class TaskCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userId=session.getAttribute("id").toString();
		String taskId=request.getParameter("tid").toString();
		UserTaskDaoImpl userTaskDaoImpl=new UserTaskDaoImpl();
		userTaskDaoImpl.delete(userId, taskId);
		request.getRequestDispatcher("/servlet/RecTskServlet").forward(request, response);;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
