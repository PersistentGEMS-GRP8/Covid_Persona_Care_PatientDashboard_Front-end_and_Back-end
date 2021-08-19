package com.management.personacovid.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.management.personacovid.model.Appointment;
import com.management.personacovid.model.Doctor;
import com.management.personacovid.repository.AppointmentRepository;
import com.management.personacovid.service.AppointmentService;
import com.management.personacovid.service.PatientService;

@ContextConfiguration(classes = {PatientService.class,AppointmentService.class})
@WebMvcTest(controllers = AppointmentController.class)
class AppointmentControllerTest {
	
	@MockBean
	private AppointmentService appointmentService;
	
	@MockBean
	private AppointmentRepository appointmentRepository;
	
	private Appointment appointment;
	
	@BeforeEach
	void setUp() throws Exception {
		
		appointment = 
				Appointment.builder()
				.a_id(1L)
				.p_id(1L)
				.date("08/25/2021 5:01 PM")
				.doctor(new Doctor(1,"D1@gmail.com","Pathak","Rubi","Jain","MS"))
				.build();
		
		Mockito.when(appointmentService.getAppointmentById(1L))
        .thenReturn(appointment);
		
	}
	
	@Test
	public void getAppointment() throws Exception {	 
		 
		 Appointment appointment = appointmentService.getAppointmentById(1L);
		 assertEquals(1L, appointment.getA_id());
		 
		
	}
}
