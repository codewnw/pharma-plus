package com.pharmaplus.service;

import java.util.List;

import com.pharmaplus.model.User;

public interface UserService {

	void save(User user);

	void update(User user);

	void delete(String id);

	User get(String id);

	List<User> getAllUsers();
}
