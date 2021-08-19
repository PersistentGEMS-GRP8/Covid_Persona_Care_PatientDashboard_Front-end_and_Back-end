package com.management.personacovid.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.management.personacovid.model.Appointment;
import com.management.personacovid.model.Doctor;
import com.management.personacovid.repository.AppointmentRepository;

@SpringBootTest
class AppointmentServiceTest {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@MockBean
	private AppointmentRepository appointmentRepository;
	
	

	@BeforeEach
	void setUp() throws Exception {
		
		Appointment appointment = 
				Appointment.builder()
				.a_id(1L)
				.p_id(1L)
				.date("08/25/2021 5:01 PM")
				.doctor(new Doctor(1,"D1@gmail.com","Pathak","Rubi","Jain","MS"))
				.build();
		
		Mockito.when(appointmentRepository.findByP_id(1L)).thenReturn(appointment);
		
	}

	
	@Test
	public void getAppointmentDetailsByPId() {
		long pId = 1L;
		Appointment appointment = appointmentService.viewAppointmentDetails(pId);
		
		assertEquals(pId, appointment.getP_id());
		assertEquals(1L, appointment.getA_id());
		assertEquals("08/25/2021 5:01 PM", appointment.getDate());
		assertEquals(1, appointment.getDoctor().getD_id());
		assertFalse(2==appointment.getDoctor().getD_id());
		assertNotNull(appointment);
	}
	
}
