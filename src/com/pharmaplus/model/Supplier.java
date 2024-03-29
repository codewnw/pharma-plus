package com.pharmaplus.model;

public class Supplier {

	private String email;

	private String name;

	private String mobile;

	private Address address;

	@Override
	public String toString() {
		return "Supplier [email=" + email + ", name=" + name + ", mobile=" + mobile + ", address=" + address + "]";
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

}
