package com.management.personacovid.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.management.personacovid.web.dto.UserRegistrationDto;

@Controller
@RestController

public class LoginDetailsController {
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
}
