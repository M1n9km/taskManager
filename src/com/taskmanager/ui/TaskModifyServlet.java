package com.taskmanager.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.impl.TaskDaoImpl;
import com.taskmanager.tool.Check;
/**
 * 修改任务界面
 * @author controller
 *
 */
public class TaskModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Check.checkAdmin(request, response);
		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		String id = request.getParameter("taskId");
		request.setAttribute("task", taskDaoImpl.find(id));
		request.getRequestDispatcher("/taskModify.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
