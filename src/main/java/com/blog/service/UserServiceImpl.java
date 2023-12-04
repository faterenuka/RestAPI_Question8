package com.blog.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.DTO.RoleDto;
import com.blog.entity.Role;
import com.blog.entity.User;
import com.blog.repo.RoleRepo;
import com.blog.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
   @Autowired
	private UserRepo userRepo;
   @Autowired
    private RoleRepo roleRepo;
   
   
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		User user = userRepo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
	@Override
	public User save(RoleDto userRegisteredDTO) {
	    Role role = null;
	    if (userRegisteredDTO.getRole().equals("USER")) {
	        role = roleRepo.findByRole("USER");
	    } else if (userRegisteredDTO.getRole().equals("ADMIN")) {
	        role = roleRepo.findByRole("ADMIN");
	    }

	    User user = new User();
	    user.setEmail(userRegisteredDTO.getEmail_id());
	    user.setUserName(userRegisteredDTO.getName());
	    user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
	    user.getRoles().add(role); // Directly add the role to the user's roles set
        
	    return userRepo.save(user);
	}
}