package com.codewithanup.blog.payloads;



import java.util.HashSet;
import java.util.Set;

import com.codewithanup.blog.entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto{

	
		private int id;
		
		@jakarta.validation.constraints.NotEmpty(message="username not be empty")
		@Size(min = 4,max=30, message ="Username must be min of 4 character's !!")
		private String name;
		
		@Email(message = "Email address is not valid !!")
		private String email;
		
		@jakarta.validation.constraints.NotEmpty
		@Size(min = 2, max= 10, message = "password must be minimmum of 3 char and max of 10 chars !!")
		private String password;
		
		@jakarta.validation.constraints.NotEmpty
		private String about;
		
		private Set<RoleDto> roles=new HashSet<>();
}
