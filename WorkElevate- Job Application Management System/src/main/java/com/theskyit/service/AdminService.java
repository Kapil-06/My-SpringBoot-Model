package com.theskyit.service;

import java.time.LocalDateTime;

import com.theskyit.dto.AdminDTO;
import com.theskyit.model.Admin;

public interface AdminService {

	void registerAdmin(AdminDTO adminDTO);

	void adminLogin(String username, String password);

	void findEmailForForget(String email);

	String findResetToken(String token, String newPassword);

	Admin findResetToken(String token);

	boolean hasExpired(LocalDateTime tokenExpiry);
	
}
