package com.management.personacovid.web.dto;


public class UserRegistrationDto {
	
	private String firstName;
	private String lastName;
	private String contactNo;
	private String email;
	private String password;
	
	public UserRegistrationDto(){
		
	}
	
	public UserRegistrationDto(String firstName, String lastName,String contactNo, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
