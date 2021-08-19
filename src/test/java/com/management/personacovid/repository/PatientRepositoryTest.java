package com.management.personacovid.repository;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.management.personacovid.model.Patient;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatientRepositoryTest {

	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testPatient() {
		Patient patient =new Patient();
		patient.setId(101);
		patient.setFirstName("Ravi");
		patient.setLastName("Kumar");
		patient.setEmail("ravikumar@gmail.com");
		patient.setContactNo("8855885588");
		patient.setVaccinationStatus(false);
		
		Patient savedPatient=patientRepository.save(patient);
		
		Patient existPatient= entityManager.find(Patient.class, savedPatient.getId());
		
		assertThat(existPatient.getEmail()).isEqualTo(patient.getEmail());
	}
	
}
