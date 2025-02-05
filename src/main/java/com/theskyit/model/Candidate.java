package com.theskyit.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="candidate")
public class Candidate {
	
	@org.springframework.data.annotation.Id
	 private String id;
	 private String name;
	 private String email;
	 private String phone;
	 private String role;
	 private String educationalQualification;
	 private double experience;
	 private String location;
	 private Date submissionDate;
	 private String resume;
	 private byte[] data;

	public Candidate(String id, String name, String email, String phone, String role, String educationalQualification,
			double experience, String location, Date submissionDate, String resume, byte[] data) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.educationalQualification = educationalQualification;
		this.experience = experience;
		this.location = location;
		this.submissionDate = submissionDate;
		this.resume = resume;
		this.data = data;
	}

	public Candidate() {
		// TODO Auto-generated constructor stub
	}

	//Getter and Setter Method
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEducationalQualification() {
		return educationalQualification;
	}

	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
