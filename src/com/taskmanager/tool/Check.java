package com.taskmanager.tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.impl.LoginDaoImpl;

public class Check extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * ����Ƿ�Ϊ����Ա
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void checkAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
		HttpSession session = request.getSession(true);
		try {
			if (!loginDaoImpl.findById(session.getAttribute("id").toString())
					.getRole().trim().equals("admin")) {
				request.getSession().removeAttribute("id");
				request.getSession().removeAttribute("role");
				String message = String
						.format("�Բ�����û���㹻Ȩ��ʹ�ã���ʹ�ù���Ա�˺ŵ�¼��2���Ϊ����ת����¼ҳ��"
								+ "<meta http-equiv='refresh' content='2;url=%s'",
								request.getContextPath()
										+ "/servlet/LoginUIServlet");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				return;
			}
		} catch (Exception e) {
			String message = String.format(
					"�Բ�����û���㹻Ȩ��ʹ�ã���ʹ�ù���Ա�˺ŵ�¼��2���Ϊ����ת����¼ҳ��"
							+ "<meta http-equiv='refresh' content='2;url=%s'",
					request.getContextPath() + "/servlet/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
	}

	/**
	 * ���������Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void message(HttpServletRequest request,
			HttpServletResponse response, String errorMessage, String url)
			throws ServletException, IOException {
		String message = String.format("%s"
				+ "<meta http-equiv='refresh' content='2;url=%s'",
				errorMessage, request.getContextPath() + url);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;
	}

	public static void messageNotRt(HttpServletRequest request,
			HttpServletResponse response, String errorMessage,String a)
			throws ServletException, IOException {
		String message = String.format("%s"+ "%s'",a,errorMessage);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;
	}
}
