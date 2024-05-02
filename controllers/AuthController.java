package com.codewithanup.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithanup.blog.entities.User;
import com.codewithanup.blog.exception.ApiException;
import com.codewithanup.blog.payloads.JwtAuthRequest;
import com.codewithanup.blog.payloads.JwtAuthResponse;
import com.codewithanup.blog.payloads.UserDto;
import com.codewithanup.blog.security.JwtTokenHelper;
import com.codewithanup.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@Valid @RequestBody JwtAuthRequest request) throws Exception {
		System.out.println(request);
		this.authenticate(request.getUserEmail(), request.getPassword());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUserEmail());

		String token = this.jwtTokenHelper.generateToken(userDetails);

		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);

		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);

	}

	private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		try {
			this.authenticationManager.authenticate(authenticationToken);

		} catch (BadCredentialsException e) {
			System.out.println("Invalid Details!!");
			throw new ApiException("Invalid Password and username !!!");
		}

	}

	
	//Register new user api
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto)
	{
		UserDto registeredUser  = this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
	}

}
