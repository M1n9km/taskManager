package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.impl.TaskDaoImpl;
import com.taskmanager.dao.impl.UserTaskDaoImpl;
import com.taskmanager.tool.Check;
/**
 * ɾ��������
 * @author controller
 *
 */
public class TaskDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Check.checkAdmin(request, response);
			TaskDaoImpl taskDaoImpl=new TaskDaoImpl();
			UserTaskDaoImpl userTaskDaoImpl=new UserTaskDaoImpl();
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String taskId=request.getParameter("taskId");
			userTaskDaoImpl.deleteByTaskId(taskId);
			taskDaoImpl.delete(taskId);
			request.getRequestDispatcher("/servlet/TaskSearchServlet").forward(
					request, response);
		} catch (Exception e) {
			Check.message(request, response, "����ʧ��,ҳ�潫��2��󷵻�", "/servlet/TaskSearchServlet");
			response.getWriter().println("����ʧ��");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
