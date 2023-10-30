package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.service.PersonService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/person") 
//tutti i metodi faranno riferimento a questo URL principale 
public class PersonController {

	@Autowired
	private PersonService personService; 
	//questo campo non è inizializzato e varrebbe null senza @Autowired
	
	@GetMapping("/list")
	public List<Person> getPersonsList(){
		//Qui non ho più la creazione della lista 
		//chiamo l'istanza automatica della classe Service
		return personService.getPersonsList();
	}
	
	@GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
		//Nella classe service definisco il metodo per cercare tramite id
		//Qui chiamo solo il metodo definito in personService
		return personService.getPersonById(id);
    }

    @PostMapping("/add")	 //Metodo trasformato in void per non creare errore di ritorno nel client Dove andrebbe gestito in ritorno dati 
//	public ResponseEntity<String> createPerson(@RequestBody Person person) {
	public void createPerson(@RequestBody Person person) {
    	//if (!personService.createPerson(person)) 
//    		return ResponseEntity.unprocessableEntity().body("Id Already exists!");
    	personService.createPerson(person);
//    	return ResponseEntity.ok("Success");
    }
    //nel PostMapping di Rested, devo impostare la Header
    //name = content-Type    value = application/json altrimenti i dati non transitano correttamente
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deletePerson(@PathVariable Long id) {
    	try{
    		personService.deletePersonById(id);
    		return new ResponseEntity<>("Object has been deleted!", HttpStatus.OK);
    	} catch (RuntimeException e) { 
    		return new ResponseEntity<>("Object not found!", HttpStatus.NOT_FOUND);
    	}
    	// posso usare una RuntimeException generica o creare una mia eccezione personalizzata
    	// come una class ObjectNotFoundException 
    	
    }
    
	
    @PutMapping("/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        personService.updatePerson(id, updatedPerson);
    }

}
