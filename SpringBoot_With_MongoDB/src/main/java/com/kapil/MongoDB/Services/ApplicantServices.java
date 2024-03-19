package com.kapil.MongoDB.Services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapil.MongoDB.Models.Applicant;
import com.kapil.MongoDB.Repositories.ApplicantRepository;

@Service
public class ApplicantServices {
	
	@Autowired
	private ApplicantRepository apprepo;
	
	public List<Applicant> getAllApplicants(){
		return apprepo.findAll();
	}
	
	public Applicant addnewApplicant(Applicant a) {
		Calendar cal=Calendar.getInstance();
		a.setApplydate(cal.getTime().toString());
		return apprepo.save(a);
	}
}
