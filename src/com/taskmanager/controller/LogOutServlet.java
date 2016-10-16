package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.tool.Check;
/**
 * ʵ��ע������
 * @author controller
 *
 */
public class LogOutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("id");
		request.getSession().removeAttribute("role");
		Check.message(request, response, "ע���ɹ���2���Ϊ����ת����¼ҳ��", "/servlet/LoginUIServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
