package com.blog.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.DTO.RoleDto;
import com.blog.service.UserService;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

	 private UserService userService;

	    public RegistrationController(UserService userService) {
	        super();
	        this.userService = userService;
	    }

	    @ModelAttribute("user")
	    public RoleDto userRegistrationDto() {
	        return new RoleDto();
	    }

	    @GetMapping
	    public String showRegistrationForm() {
	        return "register";
	    }

	    @PostMapping
	    public String registerUserAccount(@ModelAttribute("user") 
	    RoleDto registrationDto) {
	        userService.save(registrationDto);
	        return "redirect:/login";
	    }
}