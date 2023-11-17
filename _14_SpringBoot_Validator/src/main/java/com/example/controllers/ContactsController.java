package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.ContactForm;

import jakarta.validation.Valid;

//La classe ContactsController che si occuperà di gestire tutte le richieste relative ai contatti.

@Controller
@RequestMapping("/contacts")
public class ContactsController {

/*
Questo metodo mostrerà la pagina contenente il modulo per l’inserimento della
nuova voce in rubrica. L’oggetto di tipo ContactForm, aggiunto al model, servirà a inizializzare
i campi del form — inizialmente vuoti — e fungerà da contenitore per i valori inviati in fase di
submission.		
*/	@GetMapping("/new")
	public ModelAndView newContactForm() {
		return new ModelAndView("contact-form").addObject(new ContactForm());
	}
	

/*
Questo metodo intercetterà la POST con il contenuto del form,
recuperando i dati inviati e visualizzandoli in una pagina di riepilogo.
@ModelAttribute permette di associare il parametro di un metodo o il 
valore di ritorno di un metodo ad un attributo del model.
*/	@PostMapping("/new")
	public ModelAndView handleNewContactSubmission(@ModelAttribute @Valid ContactForm contactForm, Errors errors)	{
/*		@Valid  definisce contactForm come oggetto da validare
		un secondo argomento Errors, rappresenta l’esito della validazione. L’oggetto errors
		conterrà la lista degli eventuali errori riscontrati nei campi di contactForm
		Uno strumento alternativo a Error può essere BindingResult  */
		if(errors.hasErrors()) {
			return new ModelAndView("contact-form");
		}
	
		return new ModelAndView("contact-details").addObject("contact", contactForm);
	}
/*
NOTA (IMPORTANTE): ricordate di dichiarare sempre il parametro di tipo Errors immediatamente
dopo l’oggetto da validare. Se non doveste rispettare questo ordine, l’oggetto errors potrebbe non
essere popolato correttamente dal framework
*/
}
