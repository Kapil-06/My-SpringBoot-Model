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
	 private String experience;
	 private String city;
	 private String state;
	 private Date submissionDate;
	 private String resume;
	 private byte[] data;
	 private boolean isDeleted = false;

	public Candidate(String id, String name, String email, String phone, String role, String educationalQualification,
			String experience, String city, String state, Date submissionDate, String resume, byte[] data, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.educationalQualification = educationalQualification;
		this.experience = experience;
		this.city = city;
		this.state = state;
		this.submissionDate = submissionDate;
		this.resume = resume;
		this.data = data;
		this.isDeleted = isDeleted;
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	
	public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

}
