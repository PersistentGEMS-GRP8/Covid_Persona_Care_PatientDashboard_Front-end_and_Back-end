package com.management.personacovid.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.management.personacovid.model.LoginDetails;
import com.management.personacovid.repository.LoginRepository;
import com.management.personacovid.web.dto.UserRegistrationDto;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

    // To save Login Details in LoginDetails Table
	@Override
	public void save(UserRegistrationDto registrationDto,String str) {
		
		LoginDetails loginDetails = new LoginDetails(registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()),str);

		this.loginRepository.save(loginDetails);

	}
	
    //To authenticate login Credentials
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginDetails user1 = loginRepository.findByEmail(username);
		if (user1 == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user1.getEmail(), user1.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
	}
	

}
