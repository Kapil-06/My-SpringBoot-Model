package com.theskyit.dto;

import jakarta.validation.constraints.Email;

public class SkyITContactDTO {
	
	@Email(message = "Email must be a valid email")
	private String hrEmail1;
	@Email(message = "Email must be a valid email")
	private String hrEmail2;
	@Email(message = "Email must be a valid email")
	private String hrEmail3;
	@Email(message = "Email must be a valid email")
	private String businessEmail1;
	@Email(message = "Email must be a valid email")
	private String businessEmail2;
	@Email(message = "Email must be a valid email")
	private String businessEmail3;
	
	private String address1;
	private String address2;
	public String getHrEmail1() {
		return hrEmail1;
	}
	public void setHrEmail1(String hrEmail1) {
		this.hrEmail1 = hrEmail1;
	}
	public String getHrEmail2() {
		return hrEmail2;
	}
	public void setHrEmail2(String hrEmail2) {
		this.hrEmail2 = hrEmail2;
	}
	public String getHrEmail3() {
		return hrEmail3;
	}
	public void setHrEmail3(String hrEmail3) {
		this.hrEmail3 = hrEmail3;
	}
	public String getBusinessEmail1() {
		return businessEmail1;
	}
	public void setBusinessEmail1(String businessEmail1) {
		this.businessEmail1 = businessEmail1;
	}
	public String getBusinessEmail2() {
		return businessEmail2;
	}
	public void setBusinessEmail2(String businessEmail2) {
		this.businessEmail2 = businessEmail2;
	}
	public String getBusinessEmail3() {
		return businessEmail3;
	}
	public void setBusinessEmail3(String businessEmail3) {
		this.businessEmail3 = businessEmail3;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

}
