package com.kapil.MongoDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.MongoDB.Models.Applicant;
import com.kapil.MongoDB.Services.ApplicantServices;

@RestController
public class ApplicantController {

	@Autowired
	private ApplicantServices appser;
	
	@GetMapping("/applicant")
	public List<Applicant> getApplicant(){
		return appser.getAllApplicants();
	}
	
	@PostMapping("/add/applicant")
	public Applicant addApplicant(@RequestBody Applicant a) {
		return appser.addnewApplicant(a);
	}
}
