package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalutaController {

	@GetMapping("/saluta")
	public String saluta(@RequestParam String nome, Model model) {
		System.out.println(nome);  //TEST! per vedere se cattura il dato
		model.addAttribute("utente", nome);
		return "saluta"; 
	//questo metodo deve ritornare una stringa che corrisponde 
	//al nome della pagina da raggiungere
	}
}


