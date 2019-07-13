package com.pharmaplus.model;

public class Supplier {

	private int id;
	
	private String name;

	private String shortname;
	
	private int activeflag;
	// 0 for inactive and 1 for active

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", shortname=" + shortname + ", activeflag=" +activeflag+ " ]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	
	public int getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(int activeflag) {
		this.activeflag = activeflag; 
	}

}
