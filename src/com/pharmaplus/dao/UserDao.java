package com.pharmaplus.dao;

import java.util.List;

import com.pharmaplus.model.User;

public interface UserDao {

	void save(User user);

	void update(User user);

	void delete(String email);

	User get(String email);

	List<User> getAllUsers();
}
