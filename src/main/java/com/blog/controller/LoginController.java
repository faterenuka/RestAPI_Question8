package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.DTO.UserDto;
import com.blog.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController {
@Autowired
	private UserService userService;

    @ModelAttribute("user")
    public UserDto userLoginDTO() {
        return new UserDto();
    }
    
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public void  loginUser(@ModelAttribute("user") 
	UserDto userDto) {
	 userService.loadUserByUsername(userDto.getUserName());
	}
}