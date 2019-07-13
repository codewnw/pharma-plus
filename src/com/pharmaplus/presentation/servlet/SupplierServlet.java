package com.pharmaplus.presentation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pharmaplus.model.Supplier;
//import com.pharmaplus.service.LoginService;
//import com.pharmaplus.service.LoginServiceImpl;
import com.pharmaplus.service.SupplierService;
import com.pharmaplus.service.SupplierServiceImpl;


@WebServlet({ "/suppliers", "/suppliers/get", "/suppliers/update", "/suppliers/delete", "/suppliers/save" })
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final SupplierService supplierService;
	
	//private final LoginService loginService;
	
	public SupplierServlet() {
		supplierService = new SupplierServiceImpl();
		//loginService = new LoginServiceImpl();
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
				String shortname = request.getParameter("shortname");
				int id = Integer.parseInt(request.getParameter("id"));
				int activeflag = Integer.parseInt(request.getParameter("activeflag"));

				Supplier supplier = new Supplier();
				supplier.setName(name);
				supplier.setId(id);
				supplier.setShortname(shortname);
				supplier.setActiveflag(activeflag);
				
				supplierService.save(supplier);

		
		} else if (url.contains("update")) {
			// run update login

		} else if (url.contains("delete")) {
			// run delete login
		} else {
			response.sendRedirect("index.jsp");
		}

	}

}
