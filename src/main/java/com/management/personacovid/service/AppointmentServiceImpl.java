package com.management.personacovid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.management.personacovid.model.Appointment;
import com.management.personacovid.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	//This function is useful when we implement Doctor part
	@Override
	public List<Appointment> getAllAppointment() {
		return appointmentRepository.findAll();
	}

	@Override
	public void saveAppointment(Appointment appointment) {
		this.appointmentRepository.save(appointment);
	}

	@Override
	public Appointment viewAppointmentDetails(long pid) {
		
		return appointmentRepository.findByP_id(pid);
		
	}
	
	
	@Override
	public Appointment getAppointmentById(@PathVariable(value = "id")long id) {
		Optional<Appointment> optional = appointmentRepository.findById(id);
		Appointment appointment = null;
		if (optional.isPresent()) {
			appointment = optional.get();
		} else {
			throw new RuntimeException(" Appointment not found for id :: " + id);
		}
		return appointment;
	}

}
