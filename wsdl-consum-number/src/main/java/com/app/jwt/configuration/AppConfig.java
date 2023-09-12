package com.app.jwt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails users = User.builder()
				.username("dhoni")
				.password(passwordEncoder().encode("dhoni")).roles("ADMIN")
				.build();
		
		UserDetails users1 = User.builder()
				.username("sachin")
				.password(passwordEncoder().encode("sachin")).roles("ADMIN")
				.build();			
		return new InMemoryUserDetailsManager(users,users1);
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
	

}
