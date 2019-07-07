package com.pharmaplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
		// TODO Auto-generated method stub
		return null;
	}

}
