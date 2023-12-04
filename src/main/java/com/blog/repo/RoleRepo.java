package com.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Integer>{

	Role findByRole(String role);
}
