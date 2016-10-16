package com.taskmanager.ui;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.impl.TaskDaoImpl;
import com.taskmanager.entity.Task;
import com.taskmanager.tool.Check;
/**
 * 任务搜索界面
 * @author controller
 *
 */
public class TaskSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Check.checkAdmin(request, response);
		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		ArrayList<Task> tasks = taskDaoImpl.findAll();
		request.setAttribute("tasks", tasks);
		request.getRequestDispatcher("/taskSearch.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
