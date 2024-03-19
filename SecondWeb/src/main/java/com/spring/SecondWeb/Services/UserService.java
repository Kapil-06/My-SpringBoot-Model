package com.spring.SecondWeb.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public String checkUsers(String userid, String pass) {
		String status="";
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			 
			pst=con.prepareStatement("Select * from users where userid=? and pswd=?");
			pst.setString(1, userid);
			pst.setString(2, pass);
			rs=pst.executeQuery();
			if(rs.next())
				status="LoginSuccess.jsp";
			else
				status="LoginFailed.jsp";
		}
		catch(Exception e) {
			System.out.println(e);
			status="LoginFailed.jsp";
		}
		return status;
	}
}
