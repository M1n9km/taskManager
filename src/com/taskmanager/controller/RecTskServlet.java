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
 * �ѽ��������
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
				Check.message(request, response, "�Բ��𣬴��û������ڣ������µ�¼��2���Ϊ����ת����¼ҳ��",
						"/servlet/LoginUIServlet");
			}
			userTask = userTaskDaoImpl.find(id);
			request.setAttribute("taskList", userTask.getTaskList());
			request.setAttribute("userName", userDaoImpl.findById(id).getName());
			request.getRequestDispatcher("/recTsk.jsp").forward(request,
					response);
		} catch (Exception e) {
			Check.message(request, response, "�Բ������ӳ�ʱ�������µ�¼��2���Ϊ����ת����¼ҳ��", "/servlet/LoginUIServlet");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
