package com.management.personacovid.service;

import java.util.List;

import com.management.personacovid.model.Appointment;


public interface AppointmentService {
	
	List<Appointment> getAllAppointment();
	
	void saveAppointment(Appointment appointment);
	
	public Appointment viewAppointmentDetails(long id);
	
	Appointment getAppointmentById(long id);
	
	
	

}
