package com.pharmaplus.presentation.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.pharmaplus.dao.TableCreator;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

	private TableCreator tableCreator;

	public ApplicationContextListener() {
		tableCreator = new TableCreator();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		String dropTable = sce.getServletContext().getInitParameter("dropTable");
		String createTable = sce.getServletContext().getInitParameter("createTable");

		if (dropTable.equalsIgnoreCase("yes")) {
			System.out.println(getClass().getSimpleName() + " >> Droping tables....");
			tableCreator.dropTables();
		}

		if (createTable.equalsIgnoreCase("yes")) {
			System.out.println(getClass().getSimpleName() + " >> Creating tables....");
			tableCreator.createTables();
		}
	}

}
