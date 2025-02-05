package com.theskyit.service;

import com.theskyit.dto.AdminDTO;

public interface AdminService {

	void registerAdmin(AdminDTO adminDTO);

	void adminLogin(String username, String password);

	void findEmailForForget(String email);

	void findResetToken(String token, String newPassword);
	
}
