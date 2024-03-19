package com.spring.SecondWeb.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.spring.SecondWeb.entities.Accounts;

@Service
public class AccountServices {
	
	public ArrayList<Accounts> accReport(){
		ArrayList<Accounts> list=new ArrayList<>();
		
		Connection con;
		Statement pst;
		ResultSet rs;
		Accounts obj;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			 
			pst=con.createStatement();
			rs=pst.executeQuery("select * from accounts");
			while(rs.next()) {
				obj=new Accounts();
				obj.setAccno(rs.getInt("accno"));
				obj.setAccnm(rs.getString("accnm"));
				obj.setAcctype(rs.getString("acctype"));
				obj.setBalance(rs.getDouble("balance"));
				list.add(obj);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
