package com.pharmaplus.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaplus.service.LoginService;
import com.pharmaplus.service.LoginServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService;

	public LoginServlet() {
		loginService = new LoginServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		if (loginService.checkLogin(userName, password)) {
			String userType = loginService.getUserType(userName);

			switch (userType) {
			case "admin":
				request.getRequestDispatcher("WEB-INF/admin-home.jsp").forward(request, response);
				break;
			default:
				response.sendRedirect("login.jsp");
				break;
			}
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
