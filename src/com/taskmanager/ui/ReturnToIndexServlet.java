package com.taskmanager.ui;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.UserTaskDaoImpl;
import com.taskmanager.entity.Task;

/**
 * Ö÷Ò³½çÃæ
 * 
 * @author controller
 *
 */
public class ReturnToIndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		UserTaskDaoImpl userTaskDaoImpl = new UserTaskDaoImpl();
		ArrayList<Task> tasks = userTaskDaoImpl.findNotIn(id);
		request.setAttribute("tasks", tasks);
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
