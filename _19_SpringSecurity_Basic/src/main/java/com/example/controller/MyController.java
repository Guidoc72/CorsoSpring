package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping(path = {"/", "/index"})
	public String getHomePage() {
		return "index";
	}
	
	@GetMapping(path = {"admin"})
	public String getAdminPage() {
		return "admin_page";
	}	
	
}

