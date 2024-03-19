package com.kapil.Firstdemo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kapil.Firstdemo.entities.Product;

@Service
public class ProductServices {
	
	public String addcar(Product p) {
		String status="";
		
		Connection con;
		PreparedStatement pst;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("insert into products values (?,?,?,?)");
			pst.setInt(1, p.getProdid());
			pst.setString(2, p.getProdnm());
			pst.setString(3, p.getCompany());
			pst.setFloat(4, p.getPrice());
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
	
	//retrieve products details
	public ArrayList<Product> getPrductData(){
		
		ArrayList<Product> list=new ArrayList<>();
		Product p;
		Connection con;
		Statement st;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
				
			st=con.createStatement();
			rs=st.executeQuery("Select * from products");
			
			while(rs.next()) {
				p=new Product();
				p.setProdid(rs.getInt(1));
				p.setProdnm(rs.getString(2));
				p.setCompany(rs.getString(3));
				p.setPrice(rs.getFloat(4));
				list.add(p);
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	//retrieve data from product by providing company name as input
	public ArrayList<Product> getDataByComp(String comp){
		
		ArrayList<Product> list=new ArrayList<>();
		Product p;
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
				
			pst=con.prepareStatement("Select * from products where company=?");
			pst.setString(1, comp);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				p=new Product();
				p.setProdid(rs.getInt(1));
				p.setProdnm(rs.getString(2));
				p.setCompany(rs.getString(3));
				p.setPrice(rs.getFloat(4));
				list.add(p);
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
