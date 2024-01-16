package com.example.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.models.User;
import com.example.services.UserService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("saveResultMessage")
public class RegistrationContoller {

	private UserService userService;

	public RegistrationContoller(UserService userService) {
		this.userService = userService;
	}

	
/**
 * Cattura le chiamate per l'accesso al modulo di registrazione, resettando il session attribute che gestisce il popup 
 * in caso di avvenuto salvataggio di un utente: se arrivo dalla pagina Login e quindi non ho salvato nessun utente
 * imposto il messaggio a "", altrimenti lo lascio compilato ed al caricamento della pagina registration.html appare il popup
 * Poi se non esiste un elemento "user" da passare al form, ne creo uno nuovo, altrimenti gli passo quello esistente.
 * @param saving
 * @param model
 * @param user
 * @return String: registration page
 */
	@GetMapping(path = "/registration")
	public String getRegistration(@RequestParam(required = false) boolean saving,  Model model, User user) {
		System.out.println("===================================== @GetMapping( /registration ) ==================================");
		if (!saving)									//cattura la query string che arriva dal salvataggio e resetta il sessionAttribute "saveResultMessage" che gestisce il messaggio di conferma del salvataggio utente
			model.addAttribute("saveResultMessage", "");
		
		if (user != null) { 							// se riceve un utente non validato lo rimanda al form
			model.addAttribute("new_user", user);
		} else 											// altrimenti manda un utente vuoto da compilare
			model.addAttribute("new_user", new User());
		return "registration";
	}

	
	
	
/**
 * Riceve i dati del form di registrazione, li elabora e salva l'utente. I caso di incongruenza dei dati con i dati di validazione
 * rimanda al Form
 * le annotazioni @Valid e @BindingResult servono per gestire la validazione. BindingResult deve seguire l'elemento Valid e serve per catturare gli errori
 * @param user
 * @param errors
 * @param model
 * @return String: rimanda alla pagina di registrazione
 */
	
	@PostMapping("/registerRequest")
	public String getRegistrationRequest(@ModelAttribute @Valid User user, BindingResult errors, Model model) {
		System.out.println("===================================== @PostMapping( /registerRequest ) ==================================");

		if (errors.hasErrors()) {
			model.addAttribute("errors", errors.getAllErrors()); //errors.getAllErrors()
			model.addAttribute("new_user", user);
			model.addAttribute("saveResultMessage", "Compila correttamente tutti i campi richiesti (*)!");
			return "registration";
		} else {
			if (userService.addNewUser(user).equals("Ok"))
				model.addAttribute("saveResultMessage", "Il tuo profilo è stato salvato correttamente");
			else
				model.addAttribute("saveResultMessage", "Si è verificato un errore nel salvataggio del tuo profilo! Riprova...");
			
			return "redirect:registration?saving=true";
		}

	}


}
