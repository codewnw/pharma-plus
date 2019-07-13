package com.pharmaplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	public void delete(String email) {
		String DELETE_USER_QUERY = "DELETE FROM PP_USER WHERE EMAIL = ?";
		try (Connection con = DbUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_USER_QUERY)) {
			pstmt.setString(1, email);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User get(String email) {
		User user = null;
		String USER_QUERY = "SELECT * FROM PP_USER WHERE EMAIL = ?";
		try (Connection con = DbUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(USER_QUERY)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = userRecordToUserEntityMaper(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		String ALL_USER_QUERY = "SELECT * FROM PP_USER";
		try (Connection con = DbUtil.getConnection(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(ALL_USER_QUERY);
			while (rs.next()) {
				User user = userRecordToUserEntityMaper(rs);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	private User userRecordToUserEntityMaper(ResultSet rs) throws SQLException {
		String email = rs.getString("EMAIL");
		String name = rs.getString("NAME");
		String gender = rs.getString("GENDER");
		String mobile = rs.getString("MOBILE");
		int age = rs.getInt("AGE");

		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setAge(age);
		user.setGender(gender);
		user.setMobile(mobile);
		return user;
	}
}
