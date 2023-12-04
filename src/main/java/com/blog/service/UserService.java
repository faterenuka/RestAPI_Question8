package com.blog.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.blog.DTO.RoleDto;
import com.blog.entity.User;

public interface UserService {

	User save(RoleDto userRegisteredDTO);

	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}
