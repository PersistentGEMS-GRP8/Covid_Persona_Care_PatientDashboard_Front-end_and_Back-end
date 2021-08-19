package com.management.personacovid.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.management.personacovid.model.Appointment;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AppointmentRepositoryTest {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Test
	public void getAppointmentDetailById() {
		
		Appointment appointment = appointmentRepository.findById(4L).get();
		
		assertEquals(appointment.getP_id(), 4L);
		
		
	}
}
