package com.codewithanup.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class JwtAuthRequest {
	
	@NotEmpty(message="username field must not be Empty")
	private String userEmail;
	
	@NotEmpty(message="Password field must not be Empty")
	private String password;
}
