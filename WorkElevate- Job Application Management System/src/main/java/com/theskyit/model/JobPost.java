package com.theskyit.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="job_post_detils")
public class JobPost {
    
	@Id
    private String id;
	private String jobTitle;
    private String jobCategory;
    private String jobPosition;
    private String urgentRequirement;
    private String requiredQualification;
    private String jobDescription;
    private String experience;   
    private double minimumSalary;   
    private double maximumSalary;
    private List<String> customSkills;    
    private String city;
    private String state;
    private String country;
    
    
    //default construction
   	public JobPost() {
   		super();
   	}


	public JobPost(String id, String jobTitle, String jobCategory, String jobPosition, String urgentRequirement,
			String requiredQualification, String jobDescription, String experience, double minimumSalary,
			double maximumSalary, List<String> customSkills, String city, String state, String country) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobCategory = jobCategory;
		this.jobPosition = jobPosition;
		this.urgentRequirement = urgentRequirement;
		this.requiredQualification = requiredQualification;
		this.jobDescription = jobDescription;
		this.experience = experience;
		this.minimumSalary = minimumSalary;
		this.maximumSalary = maximumSalary;
		this.customSkills = customSkills;
		this.city = city;
		this.state = state;
		this.country = country;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getJobCategory() {
		return jobCategory;
	}


	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}


	public String getJobPosition() {
		return jobPosition;
	}


	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}


	public String getUrgentRequirement() {
		return urgentRequirement;
	}


	public void setUrgentRequirement(String urgentRequirement) {
		this.urgentRequirement = urgentRequirement;
	}


	public String getRequiredQualification() {
		return requiredQualification;
	}


	public void setRequiredQualification(String requiredQualification) {
		this.requiredQualification = requiredQualification;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public double getMinimumSalary() {
		return minimumSalary;
	}


	public void setMinimumSalary(double minimumSalary) {
		this.minimumSalary = minimumSalary;
	}


	public double getMaximumSalary() {
		return maximumSalary;
	}


	public void setMaximumSalary(double maximumSalary) {
		this.maximumSalary = maximumSalary;
	}


	public List<String> getCustomSkills() {
		return customSkills;
	}


	public void setCustomSkills(List<String> customSkills) {
		this.customSkills = customSkills;
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


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

}
