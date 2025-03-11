package com.theskyit.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AdminDTO {
	
	private String id;
	
	@NotBlank(message = "Username is required")
    @Size(min = 3, max = 8, message = "Username must be between 3 and 8 characters")
    private String username;

	@NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
        message = "Password must have at least 6 characters, including an uppercase letter, a lowercase letter, a digit, and a special character")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
        message = "Invalid email format")
    private String email;
    
    private String token;
	private String resetToken;
	private LocalDateTime tokenExpiry;
	
//    @NotBlank(message = "Role is required")
//    @Size(min = 6)
//    private String role;

	public AdminDTO() {
		super();
	}

	public AdminDTO(String id,
		@NotBlank(message = "Username is required") @Size(min = 3, max = 8, message = "Username must be between 3 and 8 characters") String username,
		@NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters long") String password,
		@NotBlank(message = "Email is required") @Email(message = "Please provide a valid email address") String email,
		String token, String resetToken, LocalDateTime tokenExpiry) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.email = email;
	this.token = token;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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
	
}
