package com.management.personacovid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "patient",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Patient {

	public Patient() {
		super();
	}


	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank
	@Column(name = "email",nullable=false,unique=true)
	private String email;
//	
//	@Column(name = "Passward")
//	private String password;

	@NotBlank
	@Size(min=10,max=10,message="Contact no should be between 10 to 12 characters")
    @Column(name="Contact_No")
    private String contactNo;
    
	
    @Column(name="Appointment_No")
    @ColumnDefault("0")
    private long appointmentNO;
    
    @Column(name="Vaccination_Status")
    @ColumnDefault("false")
    private boolean vaccinationStatus;
    
	
    public Patient(String firstName, String lastName,String contactNo, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		

	}
//    public Patient(long id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String email,
//    		@NotBlank @Size(min = 10, max = 12, message = "Contact no should be between 10 to 12 characters") String contactNo,
//    		long appointmentNO, boolean vaccinationStatus) {
//    		super();
//    		this.id = id;
//    		this.firstName = firstName;
//    		this.lastName = lastName;
//    		this.email = email;
//    		this.contactNo = contactNo;
//    		this.appointmentNO = appointmentNO;
//    		this.vaccinationStatus = vaccinationStatus;
//    		}


    
    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public long getAppointmentNO() {
		return appointmentNO;
	}

	public void setAppointmentNO(long appointmentNO) {
		this.appointmentNO = appointmentNO;
	}

	public boolean isVaccinationStatus() {
		return vaccinationStatus;
	}


	public void setVaccinationStatus(boolean vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}


	



}
