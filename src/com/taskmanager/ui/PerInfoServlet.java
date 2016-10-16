package com.taskmanager.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.UserDaoImpl;
import com.taskmanager.entity.User;
import com.taskmanager.tool.Check;
/**
 * ������Ϣҳ��
 * @author controller
 *
 */
public class PerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session=request.getSession(true);
			UserDaoImpl userDaoImpl=new UserDaoImpl();
			User user=userDaoImpl.findById(session.getAttribute("id").toString());
			request.setAttribute("user", user);
			request.getRequestDispatcher("/perInfo.jsp").forward(request, response);
		} catch (Exception e) {
			Check.message(request, response, "�Բ������ӳ�ʱ�������µ�¼��2���Ϊ����ת����¼ҳ��", "/servlet/LoginUIServlet");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
