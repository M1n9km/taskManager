package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.LoginDaoImpl;
import com.taskmanager.dao.impl.UserDaoImpl;
import com.taskmanager.entity.Login;
import com.taskmanager.entity.User;
import com.taskmanager.tool.Check;
import com.taskmanager.util.MD5.MD5Util;

/**
 * �����û���login����
 * 
 * @author controller
 *
 */

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String id = request.getParameter("id");
		String password = request.getParameter("password");// ��ȡ��¼��Ϣ
		LoginDaoImpl loginDao = new LoginDaoImpl();
		Login login = loginDao.find(id, MD5Util.ecodeByMD5(password));// �����¼��Ϣ
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.findById(id);
		if (login == null) {
			Check.message(request, response, "�Բ����û������������������µ�¼��2���Ϊ����ת����¼ҳ��", "/servlet/LoginUIServlet");
		}
		String role=login.getRole();
		session.setAttribute("id", id);
		session.setAttribute("role", role);
		String message = String.format("��ϲ��%s,��½�ɹ�����ҳ����2���������ҳ����"
				+ "<meta http-equiv='refresh' content='2;url=%s'",
				user.getName(), request.getContextPath() + "/servlet/ReturnToIndexServlet");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
