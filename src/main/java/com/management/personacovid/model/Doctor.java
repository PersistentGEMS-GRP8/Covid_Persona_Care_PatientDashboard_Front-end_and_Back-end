package com.management.personacovid.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;



@Entity
@Builder
@AllArgsConstructor
@Table(name = "doctor")
public class Doctor {
	

	@OneToMany(mappedBy="doctor")
    private List<Appointment> appointments;
	
	
	public Doctor(long d_id, String firstName, String lastName, String email, String specialization, String hospitalName) {
		this.d_id = d_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.specialization = specialization;
		this.hospitalName = hospitalName;
	}

	public Doctor() {
	}

	
	public Doctor(long i) {
		// TODO Auto-generated constructor stub
		this.d_id = i;
	}


	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long d_id;
	
	//@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

    
    @Column(name="Specialization")
    private String specialization;
    
    //@Column(name="Hospital_Name")
    private String hospitalName;
    
    public long getD_id() {
		return d_id;
	}

	public void setD_id(long d_id) {
		this.d_id = d_id;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
    
    public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

    
}
