package com.management.personacovid.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.management.personacovid.model.Patient;
import com.management.personacovid.repository.PatientRepository;
import com.management.personacovid.web.dto.UserRegistrationDto;

@Service
@Primary
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	
	//To save Patient Details in the Database
	@Override
	public void save(UserRegistrationDto registrationDto) {
		
		Patient user = new Patient(registrationDto.getFirstName(), registrationDto.getLastName(),registrationDto.getContactNo(),
				registrationDto.getEmail());

		 this.patientRepository.save(user);
		 
	}
	

//	public long getUserIdByUsername(String username) {
//		Patient user = patientRepository.findByEmail(username);
//		return user.getId();
//	}

	@Override
	public Patient viewPatientByEmail(String email) {
		return patientRepository.findByEmail(email);
		//return user;
	}

	
	@Override
	public void updatePatientAppDetails(long a_id, long id) {
		
		this.patientRepository.findById(a_id, id);

	}

	@Override
	public Patient getPatientByEmail(String email) {
		Optional<Patient> optional = Optional.ofNullable(patientRepository.findByEmail(email));
		Patient patient = null;
		if (optional.isPresent()) {
			patient = optional.get();
		} else {
			throw new RuntimeException(" Patient not found for email :: " + email);
		}
		return patient;
	}
}
