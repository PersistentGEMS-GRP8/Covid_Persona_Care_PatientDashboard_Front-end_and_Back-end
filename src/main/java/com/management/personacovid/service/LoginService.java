package com.management.personacovid.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.management.personacovid.web.dto.UserRegistrationDto;


public interface LoginService extends UserDetailsService{

	public void save(UserRegistrationDto registrationDto, String string);
	

}
