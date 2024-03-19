package com.restapi.demorestapi.entities;

public class Employee {
	
	private int empno;
	private String empnm;
	private String dept;
	private String post;
	private String location;
	private float salary;
	
	public Employee() {
		
	}
	
	public Employee(int empno, String empnm, String dept, String post, String location, float salary) {
		super();
		this.empno = empno;
		this.empnm = empnm;
		this.dept = dept;
		this.post = post;
		this.location = location;
		this.salary = salary;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpnm() {
		return empnm;
	}

	public void setEmpnm(String empnm) {
		this.empnm = empnm;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
		
}
