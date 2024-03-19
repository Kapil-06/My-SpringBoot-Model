package com.kapil.Firstdemo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kapil.Firstdemo.entities.Car;
import com.kapil.Firstdemo.entities.Product;
import com.kapil.Firstdemo.entities.User;
import com.kapil.Firstdemo.services.CarServices;
import com.kapil.Firstdemo.services.ProductServices;
import com.kapil.Firstdemo.services.UserServices;

@Controller
public class FirstController {
	
	@Autowired
	UserServices us;
	
	@Autowired
	CarServices cs;
	
	@Autowired
	ProductServices ps;
	
	@GetMapping("/")
	public String home(){
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public String login(String userid, String pass) {	
		String status="";
		us=new UserServices();
		status=us.checkUser(userid, pass);
		return status;
	}
	
	@GetMapping("/newuser")
	public String newUser() {
		return "newuser.jsp";
	}
	
	@PostMapping("/register")
	public String userRegister(User u) {
		String status=us.addNewUser(u);
		if(status.equals("success"))
			return "userRegisterSuccess.jsp";
		else
			return "userRegisterFailed.jsp";
	}
	
	@GetMapping("/newcar")
	public String addNewCar() {
		return "newCarEntry.jsp";
	}
	
	@PostMapping("/addcar")
	public String addCar(Car c) {
		String status=cs.newCar(c);
		if(status.equals("success"))
			return "CarAddedSuccess.jsp";
		else
			return "CarAddedFailed.jsp";
	}
	
	@GetMapping("/cardetail")
	public ModelAndView ShowCarReport() {
		ModelAndView mv=new ModelAndView();
		ArrayList<Car> list=cs.showCarReport();
		mv.setViewName("carreport.jsp");
		mv.addObject("carlist", list);
		return mv;
	}
	
	@GetMapping("/product")
	public String productsOperation() {
		return "productpage.jsp";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(Product p) {
		String status=ps.addcar(p);
		if(status.equals("success"))
			return "ProductAddedSuccess.jsp";
		else
			return "ProductAddedFailed.jsp";
	}
	
	@GetMapping("/productdetail")
	public ModelAndView showProduct() {
		ModelAndView mv=new ModelAndView();
		ArrayList<Product> list=ps.getPrductData();
		mv.setViewName("productReport.jsp");
		mv.addObject("data", list);
		return mv;
	}
	
	@GetMapping("/searchByCompany")
	public ModelAndView SearchByComp(String company) {
		System.out.println(company);
		ModelAndView mv=new ModelAndView();
		ArrayList<Product> list=ps.getDataByComp(company);
		mv.setViewName("productReport.jsp");
		mv.addObject("data", list);
		return mv;
	}
}
