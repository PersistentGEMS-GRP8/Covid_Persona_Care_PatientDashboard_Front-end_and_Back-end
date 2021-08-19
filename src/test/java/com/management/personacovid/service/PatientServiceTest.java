package com.management.personacovid.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.management.personacovid.model.Patient;
import com.management.personacovid.repository.PatientRepository;

@SpringBootTest
public class PatientServiceTest {
	@Autowired
	PatientService patientservice;

	@MockBean
	PatientRepository patientrepository;



	@BeforeEach
	void setUp() throws Exception {

	Patient patient =
				Patient.builder()
						.id(34L)
						.firstName("Neha")
						.lastName("Kale")
						.email("neha@gmail.com")
						.contactNo("2334455667")
						.appointmentNO(12L)
						.vaccinationStatus(true)
						.build();

	OngoingStubbing<Patient> thenReturn = Mockito.when(patientrepository.findByEmail("neha@gmail.com")).thenReturn(patient);

	}

	@Test
	public void getPatientDetailsByEmail() {
	String email="neha@gmail.com";
	Patient patient = patientservice.getPatientByEmail(email);

	assertEquals(email, patient.getEmail());
	assertEquals(34L, patient.getId());
	assertEquals("Neha", patient.getFirstName());
	assertEquals("Kale", patient.getLastName());
	assertEquals("2334455667", patient.getContactNo());
	assertEquals(12L, patient.getAppointmentNO());
	assertEquals(true, patient.isVaccinationStatus());
	

	}
}
