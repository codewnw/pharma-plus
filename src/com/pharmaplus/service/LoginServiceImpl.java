package com.pharmaplus.service;

import com.pharmaplus.dao.LoginDao;
import com.pharmaplus.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	private final LoginDao loginDao;

	public LoginServiceImpl() {
		this.loginDao = new LoginDaoImpl();
	}

	@Override
	public boolean save(String userName, char[] password, String userType) {
		return loginDao.save(userName, password, userType);
	}

	@Override
	public String getUserType(String userName) {
		return loginDao.getUserType(userName);
	}

	@Override
	public boolean checkLogin(String userName, String password) {
		return loginDao.checkLogin(userName, password);
	}

}
