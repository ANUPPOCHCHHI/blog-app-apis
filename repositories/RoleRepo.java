package com.codewithanup.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithanup.blog.entities.Role;
import com.codewithanup.blog.entities.User;

public interface RoleRepo extends JpaRepository<Role, Integer>{

	

}
