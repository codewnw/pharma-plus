package com.pharmaplus.service;

public interface LoginService {
	boolean save(String userName, char[] password, String userType);

	String getUserType(String userName);
}
