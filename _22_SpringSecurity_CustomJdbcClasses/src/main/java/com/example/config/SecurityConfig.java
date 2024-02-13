package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@SuppressWarnings({ "removal" })
	@Bean
	SecurityFilterChain dafaultSecFilterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests()
				.requestMatchers("/account.html", "/balance.html").hasAnyAuthority("VIEWACCOUNT", "VIEWBALANCE")
				.requestMatchers("/loans.html").hasAuthority("VIEWLOANS")
				.requestMatchers("/credit.html").hasAuthority("VIEWCREDIT")
				.requestMatchers("/user_page.html").authenticated()
				.requestMatchers("/index", "/index.html", "/").permitAll()
			.and()
			.formLogin()
			.and()
			.logout()
			.and()
			.httpBasic();
		
		return http.build();
	} 
}

