package com.theskyit.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="admin")
public class Admin {
	
	@Id
	private String id;
	private String username;
	private String password;
	private String email;
	private String resetToken;
	private LocalDateTime tokenExpiry;
	
	public Admin() {
		super();
	}

	public Admin(String id, String username, String email, String password, String resetToken, LocalDateTime tokenExpiry ) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		//this.token = token;
		this.resetToken = resetToken;
		this.tokenExpiry = tokenExpiry;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public LocalDateTime getTokenExpiry() {
		return tokenExpiry;
	}

	public void setTokenExpiry(LocalDateTime tokenExpiry) {
		this.tokenExpiry = tokenExpiry;
	}
	

//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
	
}
