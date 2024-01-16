package com.example.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthenticationController {

/**
 * Questo metodo gestisce tutte le pagine interne, recuperandole dal path scelto e indirizzando l'utente alla pagina corretta.	
 * @param session
 * @param model
 * @return String: ritorna la pagina interna richiesta, insieme ai dati di sessione dell'utente
 */
	@GetMapping(path= {"/internal_page1", "internal_page2"})
	public String getLoggedIn(HttpSession session, Model model){
        String fullUrl = ServletUriComponentsBuilder.fromCurrentRequest().toUriString(); //recupero l'url
        String[] URLelements = fullUrl.split("/");				//splitto sul char "/"
        String path = "/"+(URLelements[URLelements.length-1]);  //prendo l'ultimo elemento che non contiene / e aggiungo / per ricreare il path
		
        String user = (String) session.getAttribute("authenticatedUser");
		model.addAttribute("authenticatedUser", user);			//inoltra lo username alla view per poter visualizzare la sessione	
		if(user == null) {
			return "redirect:index";  							//se User è null butta fuori
		
		} else {
			if ("/internal_page1".equals(path)) {
				return "internal_page1";
				
			} else if("/internal_page2".equals(path)) {
				return "internal_page2";
			} 
		}
		return "redirect:index"; //non usato
		
	}
	
	
	
}
