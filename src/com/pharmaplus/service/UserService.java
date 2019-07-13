package com.pharmaplus.service;

import java.util.List;

import com.pharmaplus.model.User;

public interface UserService {

	void save(User user);

	void update(User user);

	void delete(String email);

	User get(String email);

	List<User> getAllUsers();
}
