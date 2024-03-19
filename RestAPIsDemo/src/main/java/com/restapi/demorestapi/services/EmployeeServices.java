package com.restapi.demorestapi.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.restapi.demorestapi.entities.Employee;

@Service
public class EmployeeServices {
	
	// Function 1 : get employee data from database and show it on browser.
	public ArrayList<Employee> getEmpDetails(Employee e) {
		
		ArrayList<Employee> list=new ArrayList<>();
		Connection con;
		Statement st;
		ResultSet rs;
		Employee emp;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			st=con.createStatement();
			rs=st.executeQuery("Select * from employee");
			
			while(rs.next()) {
				emp=new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEmpnm(rs.getString("empnm"));
				emp.setDept(rs.getString("dept"));
				emp.setPost(rs.getString("post"));
				emp.setLocation(rs.getString("location"));
				emp.setSalary(rs.getFloat("salary"));
				list.add(emp);
			}
			con.close();
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		return list;
	}
	
	
	//Function 2: to retrieve data from employee table by providing employee no as input
	public Employee getEmpInfo(int no) {
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		Employee emp=new Employee();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			pst=con.prepareStatement("Select * from employee where empno=?");
			pst.setInt(1, no);
			rs=pst.executeQuery();
			 
			 if(rs.next()) {
				 emp=new Employee();
				 emp.setEmpno(rs.getInt("empno"));
				 emp.setEmpnm(rs.getString("empnm"));
				 emp.setDept(rs.getString("dept"));
				 emp.setPost(rs.getString("post"));
				 emp.setLocation(rs.getString("location"));
				 emp.setSalary(rs.getFloat("salary"));
			 }
			 else {
				 emp.setEmpno(no);
				 emp.setEmpnm("Not Found");
			     emp.setDept("Not Found");
				 emp.setPost("Not Found");
				 emp.setLocation("Not Found");
				 emp.setSalary(no);
				}
			 con.close();
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
		return emp;
	}
	
	
	// Function 3 (to add new employee )
	public String addEmpData(Employee emp) {
		
		Connection con;
		PreparedStatement pst;
		String status="failed";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("insert into employee values (?,?,?,?,?,?)");
			pst.setInt(1, emp.getEmpno());
			pst.setString(2, emp.getEmpnm());
			pst.setString(3, emp.getDept());
			pst.setString(4, emp.getPost());
			pst.setString(5, emp.getLocation());
			pst.setFloat(6, emp.getSalary());
			
			int count=pst.executeUpdate();
			if(count > 0) {
				status="success";
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	//Function 4(update employee data)
	public String empUpdate(Employee emp) {
		
		Connection con;
		PreparedStatement pst;
		String status="failed";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("Update employee set salary=? where empno=?");
			pst.setFloat(1, emp.getSalary());
			pst.setInt(2, emp.getEmpno());
			
			int count=pst.executeUpdate();
			if(count > 0) {
				status="success";
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	//function 5 (Update location of employee)
	public String empLocModify(Employee emp) {
		Connection con;
		PreparedStatement pst;
		String status="failed";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("Update employee set location=? where empno=?");
			pst.setString(1, emp.getLocation());
			pst.setInt(2, emp.getEmpno());
			
			int count=pst.executeUpdate();
			if(count > 0) {
				status="success";
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	//function 6 (to delete the employee from table)
	public String deleteEmployee(int empno) {
		
		Connection con;
		PreparedStatement pst;
		String status="failed";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://bhod7pw8rcgxeqwgoffi-mysql.services.clever-cloud.com:3306/bhod7pw8rcgxeqwgoffi?user=ukdmlq4nnteyuvfo&password=stZ2gABP50qLdTH0RS3Q");
			
			pst=con.prepareStatement("Delete from employee where empno=?");
			pst.setInt(1, empno);
			
			int count=pst.executeUpdate();
			if(count > 0) {
				status="success";
			}
			else {
				status="not found";
			}
		}
		catch(Exception e) {
			System.out.println(e);	
		}
		return status;
	}
		
}
