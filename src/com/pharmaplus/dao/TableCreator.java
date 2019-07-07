package com.pharmaplus.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

	public void createTables() {
		createUserTable();
		createLoginTable();
		createMedicineTable();
	}

	public void dropTables() {
		dropUserTable();
		dropLoginTable();
		dropMedicineTable();
	}

	private void dropMedicineTable() {
		// TODO Auto-generated method stub

	}

	private void dropUserTable() {
		try (Connection con = DbUtil.getConnection(); Statement stmt = con.createStatement()) {
			stmt.execute("DROP TABLE PP_USER");
			System.out.println(getClass().getSimpleName() + " >> PP_USER table droped.");
		} catch (SQLException e) {
			System.out.println(getClass().getSimpleName() + " >> PP_USER table does not exists.");
			e.printStackTrace();
		}

	}

	private void dropLoginTable() {
		try (Connection con = DbUtil.getConnection(); Statement stmt = con.createStatement()) {
			stmt.execute("DROP TABLE PP_LOGIN");
			System.out.println(getClass().getSimpleName() + " >> PP_LOGIN table droped.");
		} catch (SQLException e) {
			System.out.println(getClass().getSimpleName() + " >> PP_LOGIN table does not exists.");
			e.printStackTrace();
		}

	}

	private void createMedicineTable() {

	}

	private void createUserTable() {
		StringBuilder CREATE_USER_TABLE_SQL = new StringBuilder();
		CREATE_USER_TABLE_SQL.append("CREATE TABLE PP_USER(").append("EMAIL VARCHAR(250),").append("NAME VARCHAR(250),")
				.append("AGE NUMBER,").append("GENDER VARCHAR(25),").append("MOBILE VARCHAR(50)").append(")");

		try (Connection con = DbUtil.getConnection(); Statement stmt = con.createStatement()) {
			stmt.execute(CREATE_USER_TABLE_SQL.toString());
			System.out.println(getClass().getSimpleName() + " >> PP_USER table created.");
		} catch (SQLException e) {
			System.out.println(getClass().getSimpleName() + " >> PP_USER table already exists.");
			e.printStackTrace();
		}
	}

	private void createLoginTable() {
		StringBuilder CREAte_LOGIN_TABLE_QUERY = new StringBuilder();
		CREAte_LOGIN_TABLE_QUERY.append("CREATE TABLE PP_LOGIN(").append("USER_NAME VARCHAR(250),")
				.append("PASSWORD VARCHAR(250),").append("USER_TYPE VARCHAR(20)").append(")");

		try (Connection con = DbUtil.getConnection(); Statement stmt = con.createStatement()) {
			stmt.execute(CREAte_LOGIN_TABLE_QUERY.toString());
			System.out.println(getClass().getSimpleName() + " >> PP_LOGIN table created.");
		} catch (SQLException e) {
			System.out.println(getClass().getSimpleName() + " >> PP_LOGIN table already exists.");
			e.printStackTrace();
		}
	}
}
