package com.department.service;

public class DepartmentServiceImpl {
	private String name;
	private int id;
	private String location;
	
	public DepartmentServiceImpl(String name, int id) {
		super();
		this.name = name;
		this.id = id;		
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String display() {
		return "[name=" + name + ", id=" + id  + ", location=" + location + "]";
	}
}
