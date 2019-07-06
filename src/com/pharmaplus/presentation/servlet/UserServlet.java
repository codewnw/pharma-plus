package com.pharmaplus.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaplus.model.User;
import com.pharmaplus.service.UserService;
import com.pharmaplus.service.UserServiceImpl;

@WebServlet({ "/users", "/users/get", "/users/update", "/users/delete", "/users/save" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	
	public UserServlet() {
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("get")) {
			// run save logic
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("save")) {
			String name = request.getParameter("name");
			User user = new User();
			user.setName(name);
			userService.save(user);
		} else if (url.contains("update")) {
			// run update login

		} else if (url.contains("delete")) {
			// run delete login
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
