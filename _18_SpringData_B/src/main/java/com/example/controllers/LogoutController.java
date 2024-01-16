package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

	
/**
 * Questo controller invalida la sessione e rimanda alla pagina di Login	
 * @param session
 * @return String: login page
 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:index";
	}
	
	
	
}
