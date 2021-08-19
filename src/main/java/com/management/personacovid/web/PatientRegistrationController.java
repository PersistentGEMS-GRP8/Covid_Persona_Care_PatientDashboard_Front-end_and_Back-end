package com.management.personacovid.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.management.personacovid.exception.PatientNotFoundException;
import com.management.personacovid.model.Patient;
import com.management.personacovid.repository.PatientRepository;
import com.management.personacovid.service.LoginService;
import com.management.personacovid.service.PatientService;
import com.management.personacovid.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class PatientRegistrationController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private LoginService loginService;

	@Autowired
	PatientRepository patientRepository;
	
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		patientService.save(registrationDto);
		loginService.save(registrationDto,"Patient");
		return "redirect:/registration?success";
	}
	
	public Patient save(Patient patient) {
		//patient.setStatus(1);
		patient = patientRepository.save(patient);
		if (patient.getId() > -1)
			return patient;
		else{
			System.out.println("A problem occurred during saving patient" );
			throw new PatientNotFoundException("A problem occurred during saving patient" );
		}
	}
	

}
