package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.impl.TaskDaoImpl;
import com.taskmanager.entity.Task;
import com.taskmanager.tool.Check;

/**
 * 添加任务处理
 * 
 * @author controller
 *
 */
public class TaskConfirmSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Check.checkAdmin(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String taskName = request.getParameter("addName").trim();
		String taskStmt = request.getParameter("addStmt").trim();
		try {
			// if(taskId.matches("[0-9]+")==false){
			// Check.message(request, response, "任务序列号需为纯数字,页面将在2秒后返回",
			// "/servlet/TaskSearchServlet");
			// return;
			// }
			// if (taskId.trim().equals("") || taskName.trim().equals("")) {
			// Check.message(request, response, "请将任务序号及任务名填写完整,页面将在2秒后返回",
			// "/servlet/TaskSearchServlet");
			// return;
			// } else {
			TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
			Task task = new Task(taskName, taskStmt);
			taskDaoImpl.add(task);
			request.getRequestDispatcher("/servlet/TaskSearchServlet").forward(
					request, response);
			// }
		} catch (Exception e) {
			response.getWriter().println("插入失败");
			Check.message(request, response, "插入失败,页面将在2秒后返回",
					"/servlet/TaskSearchServlet");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
