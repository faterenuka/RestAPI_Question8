package com.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
