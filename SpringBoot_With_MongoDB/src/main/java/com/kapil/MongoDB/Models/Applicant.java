package com.kapil.MongoDB.Models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Applicants")
public class Applicant {
	
	@Id
	private int id;
	private String name;
	private String role;
	private String qualification;
	private int experience;
	private List<String> skills;
	private String mobile;
	private String applydate;
	
	public Applicant() {
		
		name="unknown";
		role="NA";
		qualification="NA";
		experience=0;
		skills=new ArrayList<>();
		mobile="NA";
		applydate="NA";
	}

	public Applicant(int id, String name, String role, String qualification, int experience, List<String> skills,
			String mobile, String applydate) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.qualification = qualification;
		this.experience = experience;
		this.skills = skills;
		this.mobile = mobile;
		this.applydate = applydate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getApplydate() {
		return applydate;
	}

	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	
}
