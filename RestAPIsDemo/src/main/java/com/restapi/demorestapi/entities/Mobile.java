package com.restapi.demorestapi.entities;

public class Mobile {
	
	private int prodid;
	private String modelname;
	private String company;
	private String connectivity;
	private String ram;
	private String rom;
	private String color;
	private String screen;
	private int battery;
	private String processor;
	private float price;
	private double rating;
	private String purpose;
	public Mobile() {
		
	}
	
	public Mobile(int prodid, String modelname, String company, String connectivity, String ram, String rom,
			String color, String screen, int battery, String processor, float price, double rating, String purpose) {
		super();
		this.prodid = prodid;
		this.modelname = modelname;
		this.company = company;
		this.connectivity = connectivity;
		this.ram = ram;
		this.rom = rom;
		this.color = color;
		this.screen = screen;
		this.battery = battery;
		this.processor = processor;
		this.price = price;
		this.rating = rating;
		this.purpose= purpose;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}		
}
