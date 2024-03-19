package com.jpa.JPAdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jobs")
public class Jobs {

		@Id
		@Column(name="jobid")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int jobid;
		private String company;
		private String profile;
		private String skills;
		private int experience;
		public int getJobid() {
			return jobid;
		}
		public void setJobid(int jobid) {
			this.jobid = jobid;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public String getProfile() {
			return profile;
		}
		public void setProfile(String profile) {
			this.profile = profile;
		}
		public String getSkills() {
			return skills;
		}
		public void setSkills(String skills) {
			this.skills = skills;
		}
		public int getExperience() {
			return experience;
		}
		public void setExperience(int experience) {
			this.experience = experience;
		}
		
}
