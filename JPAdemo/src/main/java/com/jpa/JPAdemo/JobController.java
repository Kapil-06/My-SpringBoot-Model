package com.jpa.JPAdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.JPAdemo.entity.Jobs;
import com.jpa.JPAdemo.repositories.JobsRepository;

@Controller
public class JobController {
	
	@Autowired
	private JobsRepository jobrepo;

	@GetMapping("/newjob")
	public String jobForm() {
		return "NewJobEntry.jsp";
	}
	
	@PostMapping("/addjob")
	public String addJob(Jobs j) {
		jobrepo.save(j);
		return "JobAdded.jsp";
	}
}
