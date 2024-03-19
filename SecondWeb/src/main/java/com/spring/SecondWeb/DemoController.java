package com.spring.SecondWeb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.SecondWeb.Services.AccountServices;
import com.spring.SecondWeb.Services.UserService;
import com.spring.SecondWeb.entities.Accounts;
import com.spring.SecondWeb.entities.Celebrity;

import jakarta.servlet.http.HttpSession;

@Controller
public class DemoController {
	
	@Autowired
	UserService us;
	
	@Autowired
	AccountServices as;
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public ModelAndView userLoginAuthentication(String userid, String pass, HttpSession ses) {
		String stat="";
		stat=us.checkUsers(userid, pass);
		ses.setAttribute("uid", userid);
		String email="kapilkadu123@gmail.com";
		String mobno="9874651230";
		String address="Chandrapur Maharashtra";
		ModelAndView mv=new ModelAndView();
		mv.addObject("mail", email);
		mv.addObject("mob", mobno);
		mv.addObject("add", address);
		mv.setViewName(stat);
		
		Celebrity cel=new Celebrity();
		cel.setName("Vijay Thalapati");
		cel.setMob("5879641235");
		cel.setAge(35);
		cel.setCountry("India");
		cel.setRating(4.8);
		mv.addObject("celebrity", cel);
		return mv;
	}
	
	@GetMapping("/showfilm")
	public ModelAndView showFilm(String filmnm, String actor, String actress) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("fname", filmnm);
		mv.addObject("actor", actor);
		mv.addObject("actress", actress);
		mv.setViewName("filminfo.jsp");
		return mv;
	}
	
	@GetMapping("/accountreport")
	public ModelAndView showAccReport() {
		ArrayList<Accounts> list;
		list=as.accReport();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AccountReport.jsp");
		mv.addObject("acclist", list);
		return mv;
	}
}
