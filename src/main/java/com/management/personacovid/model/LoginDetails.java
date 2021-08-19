package com.management.personacovid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "loginDetails",uniqueConstraints = @UniqueConstraint(columnNames = "Username"))
public class LoginDetails {

	public LoginDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long l_id;

	@NotBlank
	@Column(name = "Username",nullable=false,unique=true)
	private String email;

	@NotBlank
	@Column(name = "Passward")
	private String password;
	
	@Column(name = "RefKey")
	private String refKey;
	
	
	public LoginDetails(String email, String password,String refKey) {
		this.email = email;
		this.password = password;
		this.refKey = refKey;
	}
	
	public long getL_id() {
		return l_id;
	}

	public void setL_id(long l_id) {
		this.l_id = l_id;
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
	
	public String getRefKey() {
		return refKey;
	}

	public void setRefKey(String refKey) {
		this.refKey = refKey;
	}
	
}
