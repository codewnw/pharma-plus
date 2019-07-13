package com.pharmaplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean save(String userName, char[] password, String userType) {
		System.out.println(getClass().getSimpleName() + " >> Inserting login.");
		String INSER_LOGIN_QUERY = "INSERT INTO PP_LOGIN VALUES(?, ?, ?)";

		try (Connection con = DbUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSER_LOGIN_QUERY)) {
			pstmt.setString(1, userName);
			pstmt.setString(2, password.toString());
			pstmt.setString(3, userType);

			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getUserType(String userName) {
		String USER_TYPE_QUERY = "SELECT USER_TYPE FROM PP_LOGIN WHERE USER_NAME = ?";
		try (Connection con = DbUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(USER_TYPE_QUERY)) {
			pstmt.setString(1, userName);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkLogin(String userName, String password) {
		String CHECK_LOGIN_QUERY = "SELECT * FROM PP_LOGIN WHERE USER_NAME = ? AND PASSWORD = ?";
		try (Connection con = DbUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(CHECK_LOGIN_QUERY)) {
			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
