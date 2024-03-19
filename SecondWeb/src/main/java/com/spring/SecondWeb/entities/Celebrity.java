package com.spring.SecondWeb.entities;

public class Celebrity {
	
	private String name;
	private String mob;
	private String country;
	private int age;;
	private double rating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double d) {
		this.rating = d;
	}
	
}
