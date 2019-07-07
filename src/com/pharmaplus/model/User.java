package com.pharmaplus.model;

public class User {

	private String email;

	private String name;

	private int age;

	private String gender;

	@Override
	public String toString() {
		return "User [userName=" + email + ", name=" + name + ", age=" + age + ", gender=" + gender + ", mobile="
				+ mobile + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private String mobile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
