package com.boot.fos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class JwtRequest {
	
	String username;
	String password;
	
	
	
}
