package com.web.film_review.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.web.film_review.entities.Admin;

@Service
public class AdminServices {
	
	public String checkAdmin(String id, String psw) {
		
		String status="";
		Connection con;
		ResultSet rs;
		PreparedStatement pst;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("Select * from adminusers where userid=? and pswd=?");
			pst.setString(1, id);
			pst.setString(2, psw);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				status="AdminLoginSuccess.jsp";
			}
			else {
				status="AdminLoginFailed.jsp";
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
}
