/*
	In questo esempio, la classe ContactWebController utilizza l’annotazione @Controller per indicare che è un controller web. 
	La classe ContactWebController definisce i metodi per gestire le richieste HTTP per le operazioni sui contatti.

	Il metodo getAllContacts gestisce le richieste HTTP GET per ottenere tutti i contatti. 
	Il metodo getContactById gestisce le richieste HTTP GET per ottenere un contatto specifico. 
	Il metodo addContactForm gestisce le richieste HTTP GET per visualizzare il form per aggiungere un nuovo contatto. 
	Il metodo addContactSubmit gestisce le richieste HTTP POST per aggiungere un nuovo contatto. 
	Il metodo editContactForm gestisce le richieste HTTP GET per visualizzare il form per modificare un contatto esistente. 
	Il metodo editContactSubmit gestisce le richieste HTTP POST per modificare un contatto esistente. 
	Il metodo deleteContactForm gestisce le richieste HTTP GET per visualizzare il form per eliminare un contatto esistente. 
	Il metodo deleteContactSubmit gestisce le richieste HTTP POST per eliminare un contatto esistente.

	In ogni metodo, viene utilizzata l’istanza di ContactService per eseguire le operazioni richieste sui contatti. 
	I metodi restituiscono il nome della vista Thymeleaf da visualizzare.
*/
package com.example.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.example.models.Contact;
import com.example.services.ContactService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    
	private static final Log logger = LogFactory.getLog(ContactController.class);
	private ContactService service;
    
    //@Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllContacts(Model model) {
    	//crea un oggetto "contacts" contenente tutti i contatti recuperati con 
    	//service.getAllContacts() e lo invia alla view per popolare la tabella
    	model.addAttribute("contacts", service.getAllContacts());
    	//crea un oggetto "contact" vuoto e lo invia alla view per essere popolato con i dati del form
        model.addAttribute("contact", new Contact());
        return "contacts";
    }
        
    @PostMapping() // contiene l'addContact
    public String addContactSubmit(@ModelAttribute @Valid Contact contact,Errors errors) {
    	//chiama la classe service e aggiunge il nuovo contatto inserito nel form, nel Database
    	if(errors. hasErrors()){
    		return "contacts";
    	}
    	service.addContact(contact);
    	logger.info("--> Contact added to DB");

    	return "redirect:/contacts";
    }

   
    //GLI ALTRI METODI
    
//    @GetMapping("/{id}")
//    public String getContactById(@PathVariable int id, Model model) {
//        Contact contact = service.getContactById(id);
//        if (contact == null) {
//            return "not-found";
//        }
//        model.addAttribute("contact", contact);
//        return "contact";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String editContactForm(@PathVariable int id, Model model) {
//        Contact contact = service.getContactById(id);
//        if (contact == null) {
//            return "not-found";
//        }
//        model.addAttribute("contact", contact);
//        return "edit-contact";
//    }
//
//    @PostMapping("/{id}/edit")
//    public String editContactSubmit(@PathVariable int id, @ModelAttribute Contact contact) {
//        contact.setId(id);
//        service.updateContact(contact);
//        return "redirect:/contacts";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String deleteContactForm(@PathVariable int id, Model model) {
//        Contact contact = service.getContactById(id);
//        if (contact == null) {
//            return "not-found";
//        }
//        model.addAttribute("contact", contact);
//        return "delete-contact";
//    }
//
//    @PostMapping("/{id}/delete")
//    public String deleteContactSubmit(@PathVariable int id) {
//        service.deleteContactById(id);
//        return "redirect:/contacts";
//    }
}

