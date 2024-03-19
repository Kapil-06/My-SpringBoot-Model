package com.restapi.demorestapi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.demorestapi.entities.Employee;
import com.restapi.demorestapi.services.EmployeeServices;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeServices es;
	
	// http://localhost:8080/api/emp
	@GetMapping("/emp/static")
	public Employee showEmp() {
		Employee obj=new Employee(101, "Rahul", "Admin", "Manager", "Pune", 65000);
		return obj;
	}
	
	//http://localhost:8080/api/emp/get/data
	@GetMapping("/emp/get/data")
	public ArrayList<Employee> getEmpData(Employee e){
		ArrayList<Employee> list=es.getEmpDetails(e);
		return list;
	}
	
	// http://localhost:8080/api/emp/get/data/101
	@GetMapping("/emp/get/{empno}")
	public Employee showEmpByNo(@PathVariable int empno) {
		Employee emp=es.getEmpInfo(empno);
		return emp;
	}
	
	
	//http://localhost:8080/api/emp/store
	@PostMapping("/emp/add/data")
	public String addNewEmp(@RequestBody Employee e) {
		String status=es.addEmpData(e);
		return status;
	}
	
	//http://localhost:8080/api/emp/update
	@PutMapping("/emp/salary/update")
	public String empDataUpdate(@RequestBody Employee e) {
		String status=es.empUpdate(e);
		return status;
	}
	
	//http://localhost:8080/api/emp/loc/update
	@PutMapping("/emp/loc/modify")
	public String empLocUpdate(@RequestBody Employee e) {
		String status=es.empLocModify(e);
		return status;
	}
	
	//http://localhost:8080/api/emp/delete
	@DeleteMapping("/emp/delete")
	public String empDelete(@RequestParam int empno) {
		String status=es.deleteEmployee(empno);
		return status;
	}
}
