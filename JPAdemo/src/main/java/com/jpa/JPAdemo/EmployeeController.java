package com.jpa.JPAdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.JPAdemo.entity.Employee;
import com.jpa.JPAdemo.repositories.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@GetMapping("/newemp")
	public String addEmp() {
		return "NewEmployeeForm.jsp";
	}
	
	@PostMapping("/addemp")
	public String addEmployee(Employee e) {
		emprepo.save(e);
		return "EmpAddSuccess.jsp";
	}
	
	@GetMapping("/allemp")
	public ModelAndView empReport(Employee emp) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("EmpReport.jsp");
		List<Employee> list=emprepo.findAll();
		System.out.println("Employee data size : "+list.size());
		mv.addObject("emplist", list);
		return mv;
	}
	
	@GetMapping("/empdelete")
	public String empDelete() {
		return "EmpDelete.jsp";
	}
	
	@PostMapping("/delemp")
	public String delEmp(int empno) {
		Employee obj=emprepo.findByEmpno(empno);
		emprepo.delete(obj);
		return "index.jsp";
	}
}
