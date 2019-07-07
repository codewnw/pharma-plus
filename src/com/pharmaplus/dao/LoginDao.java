package com.pharmaplus.dao;

public interface LoginDao {

	boolean save(String userName, char[] password, String userType);

	String getUserType(String userName);
}
