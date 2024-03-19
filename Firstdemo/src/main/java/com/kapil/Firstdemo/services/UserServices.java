package com.kapil.Firstdemo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;
import com.kapil.Firstdemo.entities.User;

@Service
public class UserServices {
	
	//Login Form
	public String checkUser(String id, String pw) {
		 String status="";
		 Connection con;
		 PreparedStatement pst;
		 ResultSet rs;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			 
			 pst=con.prepareStatement("Select * from users where userid=? and pswd=?");
			 pst.setString(1, id);
			 pst.setString(2, pw);
			 rs=pst.executeQuery();
			 if(rs.next())
				 status="LoginSuccess.jsp";
			 else
				 status="Failure.jsp";
		 }
		 catch(Exception e) {
			 System.out.println(e);
			 status="Failure.jsp";
		 }
		 
		 return status;
	}
	
	
	//New Users Registration Form
	public String addNewUser(User u) {
		String status="";
		
		Connection con;
		PreparedStatement pst;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("insert into users values(?,?,?,default,default,?,?,?)");
			pst.setString(1, u.getUserid());
			pst.setString(2, u.getPass());
			pst.setString(3, u.getUsernm());
			pst.setInt(4, u.getAccno());
			pst.setString(5, u.getBranch());
			pst.setString(6, u.getMobile());
			pst.executeUpdate();
			con.close();
			status="success";
		}
		catch(Exception e) {
			status="error";
			System.out.println(e);
		}
		return status;
	}
	
}
