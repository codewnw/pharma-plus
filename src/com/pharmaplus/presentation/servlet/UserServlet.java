package com.pharmaplus.presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaplus.model.User;
import com.pharmaplus.service.LoginService;
import com.pharmaplus.service.LoginServiceImpl;
import com.pharmaplus.service.UserService;
import com.pharmaplus.service.UserServiceImpl;

@WebServlet({ "/users/all", "/users/get", "/users/update", "/users/delete", "/users/save" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final UserService userService;

	private final LoginService loginService;

	public UserServlet() {
		userService = new UserServiceImpl();
		loginService = new LoginServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("get")) {
			// run save logic
		} else if (url.contains("all")) {
			List<User> users = userService.getAllUsers();
			request.setAttribute("users", users);
			request.getRequestDispatcher("../WEB-INF/users.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			String email = request.getParameter("email");
			userService.delete(email);
			List<User> users = userService.getAllUsers();
			request.setAttribute("users", users);
			request.getRequestDispatcher("../WEB-INF/users.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("save")) {
			String email = request.getParameter("email");
			char[] password = request.getParameter("password").toCharArray();

			if (loginService.save(email, password, "user")) {
				String name = request.getParameter("name");
				String mobile = request.getParameter("mobile");
				int age = Integer.parseInt(request.getParameter("age"));
				String gender = request.getParameter("gender");

				User user = new User();
				user.setEmail(email);
				user.setName(name);
				user.setAge(age);
				user.setGender(gender);
				user.setMobile(mobile);

				userService.save(user);

			}

		} else if (url.contains("update")) {
			// run update login

		} else if (url.contains("delete")) {
			// run delete login
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
