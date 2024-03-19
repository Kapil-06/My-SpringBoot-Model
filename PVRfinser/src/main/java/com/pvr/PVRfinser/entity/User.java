package com.pvr.PVRfinser.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contactinfo")
public class User {
	
	@Id
	@Column(name="id")
	private int id;
	
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String message;
	
	 public User() {
	        // Default constructor logic, if needed
	    }
	
	public User(int id, String firstname, String lastname, String email, String phone, String message) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.message = message;
	}
	
	public User(int id, String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
		
		firstname="";
		lastname="";
		email="";
		phone="";
		message="";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
		
}
