package com.theskyit.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class JobPostDTO {
	
	@NotNull(message = "Job Title cannot be null")
    private String jobTitle;
    @NotNull(message = "Job Category cannot be null")
    private String jobCategory;
    @NotNull(message = "Job Position cannot be null")
    private String jobPosition;
    
    private String urgentRequirement;
    
    @NotNull(message = "Required Qualification cannot be null")
    private String requiredQualification;
    @Size(max = 1500, message = "Job Description should be less than 1500 characters")
    private String jobDescription;  
    //@Min(value = 0, message = "Experience cannot be negative")
    private String experience;
    @Min(value = 0, message = "Minimum Salary cannot be negative")
    private double minimumSalary;
    @Min(value = 0, message = "Maximum Salary cannot be negative")
    private double maximumSalary;
    
    private List<String> customSkills;
    
    private String city;
    private String state;
    private String country;

    //Constructor
	public JobPostDTO() {
		super();
	}

	public JobPostDTO(@NotNull(message = "Job Title cannot be null") String jobTitle,
			@NotNull(message = "Job Category cannot be null") String jobCategory,
			@NotNull(message = "Job Position cannot be null") String jobPosition,
			String urgentRequirement ,
			@NotNull(message = "Required Qualification cannot be null") String requiredQualification,
			@Size(max = 1500, message = "Job Description should be less than 1500 characters") String jobDescription,
			String experience,
			@Min(value = 0, message = "Minimum Salary cannot be negative") double minimumSalary,
			@Min(value = 0, message = "Maximum Salary cannot be negative") double maximumSalary,
			List<String> customSkills, String city, String state, String country) {
		super();
		this.jobTitle = jobTitle;
		this.jobCategory = jobCategory;
		this.jobPosition = jobPosition;
		this.urgentRequirement = urgentRequirement ;
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

	public void setMinimumExperience(String experience) {
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
