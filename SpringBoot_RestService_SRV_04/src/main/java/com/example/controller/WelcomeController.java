package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    // o @Controller per applicazione WEB
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Srping Framework";
	}
	
	@RequestMapping(value= {"/demo1", "/demo2"})
	public String multiUrl() {
		return "Multi URL capture method";
	}
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}
}
