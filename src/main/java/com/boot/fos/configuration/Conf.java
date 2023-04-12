package com.boot.fos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Conf{

	@Autowired
	private UserDetailsService userDetails;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		DefaultSecurityFilterChain build = http.build(); 
//		return build;
//	}
//	
//	@Bean
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(this.userDetails).passwordEncoder(passwordEncoder());
//	}
//	
	
}
	