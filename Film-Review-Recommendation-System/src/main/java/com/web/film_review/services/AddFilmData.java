package com.web.film_review.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Service;

import com.web.film_review.entities.FilmsInfo;

@Service
public class AddFilmData {
	
	public String newFilm(FilmsInfo f) {
		
		String status="";
		Connection con;
		PreparedStatement pst;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("insert into films values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, f.getId());
			pst.setString(2, f.getName());
			pst.setString(3, f.getLanguage());
			pst.setString(4, f.getCountry());
			pst.setString(5, f.getCategory());
			pst.setInt(6, f.getRelyear());
			pst.setString(7, f.getCertificate());
			pst.setString(8, f.getDirector());
			pst.setString(9, f.getActor());
			pst.setString(10, f.getActress());
			pst.setString(11, f.getMusic());
			pst.setString(12, f.getPlatform());
			pst.setLong(13, f.getBudget());
			pst.setLong(14, f.getCollection());
			pst.setString(15, f.getLink());
			
			pst.executeUpdate();
			con.close();
			status="success";
			
		}
		catch(Exception e) {
			System.out.println(e);
			status="error";
		}
		return status;
	}
	
	
	public String updateFilmData(FilmsInfo f) {
		
		Connection con;
		PreparedStatement pst;
		String status;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("update films set platform=?, collection=? where id=?");
			pst.setString(1, f.getPlatform());
			pst.setLong(2, f.getCollection());
			pst.setInt(3, f.getId());
			
			pst.executeUpdate();
			con.close();
			status="success";
		}
		catch(Exception e) {
			System.out.println(e);
			status="error";
		}
		return status;
		
	}
}
