package com.kapil.Firstdemo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kapil.Firstdemo.entities.Car;

@Service
public class CarServices {
	
	public String newCar(Car c) {
		String status="";
		
		Connection con;
		PreparedStatement pst;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("insert into cardetails values (?,?,?,?)");
			pst.setInt(1, c.getSrno());
			pst.setString(2, c.getCarnm());
			pst.setString(3, c.getCompany());
			pst.setLong(4, c.getPrice());
			
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
	
	public ArrayList<Car> showCarReport(){
		
		ArrayList<Car> list=new ArrayList<>();
		Connection con;
		Statement st;
		ResultSet rs;
		Car obj;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			st=con.createStatement();
			rs=st.executeQuery("Select * from cardetails");
			while(rs.next()) {
				obj=new Car();
				obj.setSrno(rs.getInt("srno"));
				obj.setCarnm(rs.getString("carnm"));
				obj.setCompany(rs.getString("company"));
				obj.setPrice(rs.getLong("price"));
				list.add(obj);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
