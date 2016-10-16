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
 * 处理修改任务
 * @author controller
 *
 */
public class ModifyConfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Check.checkAdmin(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String taskId = request.getParameter("tid").toString();
		String taskName = request.getParameter("name").toString();
		String taskStmt = request.getParameter("stmt").toString();
		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		Task task = new Task(taskId, taskName, taskStmt);
		try {
//			System.out.println(taskId + taskName + taskStmt);
			taskDaoImpl.update(task);
			request.getRequestDispatcher("/servlet/TaskSearchServlet").forward(
					request, response);
		} catch (Exception e) {
			response.setContentType("text/html;charset=gbk");
			response.setCharacterEncoding("utf-8");
			response.getWriter().println("对不起，保存失败，请正确输入，任务序号需为数字");
			e.printStackTrace();
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
