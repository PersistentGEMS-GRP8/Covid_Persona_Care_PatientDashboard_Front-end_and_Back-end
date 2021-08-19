package com.management.personacovid.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.management.personacovid.repository.PatientRepository;
import com.management.personacovid.service.LoginService;
import com.management.personacovid.web.dto.UserRegistrationDto;

@SpringBootTest
public class PatientControllerTest {

	@Autowired
	PatientRegistrationController patientRegistrationController;
	
	@MockBean
	PatientRepository patientRepository;
	
	@Autowired
	LoginService loginService;
	
	@Test
	public void savePatient() {
		UserRegistrationDto p1=new UserRegistrationDto("Ravi", "kumar","8855885588", "ravi@gmail.com", "ravi123");
		loginService.save(p1,"Patient");
		assertThat(p1.getEmail()).isNotNull();
		
	}
}
