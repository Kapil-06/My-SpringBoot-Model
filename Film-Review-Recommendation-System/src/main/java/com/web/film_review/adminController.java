package com.web.film_review;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.film_review.entities.FilmsInfo;
import com.web.film_review.services.AddFilmData;
import com.web.film_review.services.AdminServices;
import com.web.film_review.services.FilmService;

@Controller
public class adminController {
	
	@Autowired
	AdminServices as;
	
	@Autowired
	FilmService fs;
	
	@GetMapping("/admin")
	public String adminLogin() {
		return "adminlogin.jsp";
	}
	
	@PostMapping("/login")
	public String adminCheck(String userid, String password) {
		String status="";
		status=as.checkAdmin(userid, password);
		return status;
	}
	
	@GetMapping("/addfilm")
	public String addFilm() {
		return "AddNewFilms.jsp";
	}
	
	@PostMapping("/addfilmdata")
	public String addFilmData(FilmsInfo f) {
		System.out.println("link : "+f.getLink());
		String status=fs.newFilm(f);
		if(status.equals("success"))
			return "filmsAddSuccess.jsp";
		else
			return "failed.jsp";
	}
	
	@GetMapping("/modify")
	public String modifyFilm() {
		return "modify.jsp";
	}
	
	@PostMapping("/updatefilmdata")
	public String modifyData(FilmsInfo f) {
		System.out.println(f.getCollection());
		System.out.println(f.getPlatform());
		String status=fs.updateFilmData(f);
		if(status.equals("success"))
			return "filmsAddSuccess.jsp";
		else
			return "failed.jsp";
	}
	
	@PostMapping("/report")
	public ModelAndView filmsReport(int id){
		ArrayList<FilmsInfo> list=fs.filmsData(id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Report.jsp");
		mv.addObject("data", list);
		return mv;
	}
	
	@GetMapping("FilmsReport")
	public ModelAndView allFilmsReport() {
		ArrayList<FilmsInfo> list=fs.showFilmsReport();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Report.jsp");
		mv.addObject("data", list);
		return mv;
	}
	
	@PostMapping("/delete")
	public String filmDelete(int id) {
		String status=fs.deleteFilm(id);
		if(status.equals("success"))
			return "AdminLoginSuccess.jsp";
		else
			return "failed.jsp";
	}
}
