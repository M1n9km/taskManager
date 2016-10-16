package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.UserTaskDaoImpl;
/**
 * 处理领取任务
 * @author Administrator
 *
 */
public class GetTaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session=request.getSession();
			UserTaskDaoImpl userTaskDaoImpl=new UserTaskDaoImpl();
			String id=session.getAttribute("id").toString();
			String taskId=request.getParameter("tid").toString();
			userTaskDaoImpl.add(id, taskId);
			request.getRequestDispatcher("/servlet/ReturnToIndexServlet").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("/servlet/ReturnToIndexServlet").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
