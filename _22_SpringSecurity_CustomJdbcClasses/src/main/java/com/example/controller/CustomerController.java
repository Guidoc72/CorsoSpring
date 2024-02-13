package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.repository.CustomerRepository;



@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping(path = {"/index.html", "/", "index"})
	public String getHome() {
		System.out.println(customerRepository.findAll());
		return "index";
	}
	
	@GetMapping("/user_page.html")
	public String getUserPage() {
		return "user_page";
	}	
	
	@GetMapping("/admin_page.html")
	public String getAdminPage() {
		return "admin_page";
	}	
	
	
}

