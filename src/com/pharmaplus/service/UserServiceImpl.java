package com.pharmaplus.service;

import java.util.List;

import com.pharmaplus.dao.UserDao;
import com.pharmaplus.dao.UserDaoImpl;
import com.pharmaplus.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String email) {
		userDao.delete(email);
	}

	@Override
	public User get(String email) {
		return userDao.get(email);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
