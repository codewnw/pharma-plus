package com.pharmaplus.presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaplus.model.Supplier;
import com.pharmaplus.model.User;
import com.pharmaplus.service.LoginService;
import com.pharmaplus.service.LoginServiceImpl;
//import com.pharmaplus.service.LoginService;
//import com.pharmaplus.service.LoginServiceImpl;
import com.pharmaplus.service.SupplierService;
import com.pharmaplus.service.SupplierServiceImpl;

@WebServlet({ "/suppliers/all", "/suppliers/view", "/suppliers/update", "/suppliers/delete", "/suppliers/save" })
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final SupplierService supplierService;

	private final LoginService loginService;

	public SupplierServlet() {
		supplierService = new SupplierServiceImpl();
		loginService = new LoginServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("view")) {
			String email = request.getParameter("email");
			Supplier supplier = supplierService.get(email);
			request.setAttribute("supplier", supplier);
			System.out.println("hen");
			request.getRequestDispatcher("../WEB-INF/supplier.jsp").forward(request, response); 
		}else if (url.contains("all")) {
			System.out.println("henlwknd");
			List<Supplier> suppliers = supplierService.getAllSuppliers();
			System.out.println(suppliers);
			request.setAttribute("suppliers", suppliers);
			request.getRequestDispatcher("../WEB-INF/suppliers.jsp").forward(request, response);
		} else if (url.contains("delete")) {
			String email = request.getParameter("email");
			supplierService.delete(email);
			List<Supplier> suppliers = supplierService.getAllSuppliers();
			request.setAttribute("suppliers", suppliers);
			request.getRequestDispatcher("../WEB-INF/suppliers.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		if (url.contains("save")) {

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			char[] password = request.getParameter("password").toCharArray();

			Supplier supplier = new Supplier();
			supplier.setName(name);
			supplier.setEmail(email);
			supplier.setMobile(mobile);
			supplier.setAddress(null);

			if (loginService.save(email, password, "supplier")) {
				supplierService.save(supplier);
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
