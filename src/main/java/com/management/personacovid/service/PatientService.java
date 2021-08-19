package com.management.personacovid.service;

import com.management.personacovid.model.Patient;
import com.management.personacovid.web.dto.UserRegistrationDto;

public interface PatientService{
	
	public Patient getPatientByEmail(String email);

	public void save(UserRegistrationDto registrationDto);
	
	public void updatePatientAppDetails(long a_id,long id);

	public Patient viewPatientByEmail(String email);


}
