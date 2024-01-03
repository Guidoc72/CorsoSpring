package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Ordine;
import com.example.models.Prodotto;

@Controller
public class IndexController {

	@GetMapping(path = {"/", "/index"})
	public String getIndex() {
		return "index";
	}

}
