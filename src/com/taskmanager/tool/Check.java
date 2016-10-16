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
	 * 检查是否为管理员
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
						.format("对不起，您没有足够权限使用，请使用管理员账号登录，2秒后为您跳转到登录页面"
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
					"对不起，您没有足够权限使用，请使用管理员账号登录，2秒后为您跳转到登录页面"
							+ "<meta http-equiv='refresh' content='2;url=%s'",
					request.getContextPath() + "/servlet/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
	}

	/**
	 * 处理错误信息
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
