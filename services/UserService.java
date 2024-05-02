package com.codewithanup.blog.services;

import java.util.List;

import com.codewithanup.blog.payloads.UserDto;

public interface UserService {

	UserDto registerNewUser(UserDto user);
	
	// create
	UserDto createUser(UserDto user);

	// update
	UserDto updateUser(UserDto user, Integer userId);

	// get single user
	UserDto getUserById(Integer userId);

	// get all user
	List<UserDto> getAllUsers();

	// delete user
	void deleteUser(Integer userId);

}