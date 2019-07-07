package com.pharmaplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.pharmaplus.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		System.out.println(getClass().getSimpleName() + " >> Inserting user.");
		String INSER_USER_QUERY = "INSERT INTO PP_USER VALUES(?, ?, ?, ?, ?)";

		try (Connection con = DbUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSER_USER_QUERY)) {
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getName());
			pstmt.setInt(3, user.getAge());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getMobile());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
