package com.boot.fos.dto;


public class CustomerDTO {

	private String custEmail;
	private String custFirstName;
	private String custLastName;
	private String custPassword;
	
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustFirstName() {
		return custFirstName;
	}
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}
	public String getCustLastName() {
		return custLastName;
	}
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	
	public CustomerDTO(String custEmail, String custFirstName, String custLastName, String custPassword) {
		super();
		this.custEmail = custEmail;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custPassword = custPassword;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [custEmail=" + custEmail + ", custFirstName=" + custFirstName + ", custLastName="
				+ custLastName + ", custPassword=" + custPassword + "]";
	}
	public CustomerDTO() {
		super();
	}
	
	
	
}
