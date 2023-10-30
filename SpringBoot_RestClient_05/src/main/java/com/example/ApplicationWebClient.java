//CLIENT on PORT 8081
package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Person;
import com.example.utility.Person_WEB_Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ApplicationWebClient {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationWebClient.class, args);
		

		Person_WEB_Client pwc = new Person_WEB_Client();
		
		//GetList
		//Gli elementi estratti nel tipo Flux possono essere utlizzati in diversi modi:
		//stampati tramite il metodo subscribe()
		Flux<Person> personFlux = pwc.getPersonList();
		personFlux.subscribe(person -> System.out.println(person));
		
		//oppure trasformati in ArrayList per essere gestiti
		//Mono è una classe di Reactor Core che rappresenta un valore che può essere emesso in modo asincrono. 
		//Mono viene utilizzato per rappresentare un valore che può essere emesso in modo continuo.
		Mono<List<Person>> personListMono = personFlux.collectList(); 
		//collectList() converte il flusso in un oggetto Mono
		List<Person> personList = personListMono.block();
		//il metodo block() viene utilizzato per bloccare il thread corrente e ottenere la lista di oggetti Person.
		System.out.println(personList);
		
		
		//getPersonById  -  ritorna un oggetto Mono
		Mono<Person> onePerson = pwc.getPersonById(1);
		Person p1 = onePerson.block();
		System.out.println("GET ONE BY ID");
		System.out.println(p1);
		
		//Update Person
		p1.setFirstName("Alfonso");
		p1.setLastName("Gandolfo");
		Mono<Void>updateResult = pwc.updatePerson(p1);
		updateResult.subscribe();
		System.out.println("UPDATED");
		personFlux = Flux.empty(); //devo svuotare l'oggetto Flux altrimenti continuo ad accodare elementi
		personFlux = pwc.getPersonList(); 
		personFlux.subscribe(pp1 -> System.out.println(pp1));
		
		//Add Person
		Person p2 = new Person(4, "Sonia", "Antonelli");
		Mono<Person> addPerson = pwc.addPerson(p2);
		addPerson.block();

		
		//Delete Bi Id
		pwc.deletePersonById(2).subscribe();
		System.out.println("DELETE");
		personFlux = Flux.empty();
		personFlux = pwc.getPersonList(); 
		personFlux.subscribe(pp3 -> System.out.println(pp3));
	}
}
