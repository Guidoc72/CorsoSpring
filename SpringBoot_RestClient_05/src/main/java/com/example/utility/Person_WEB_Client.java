package com.example.utility;

import com.example.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
/* 
  Il framework web reactive-stack, Spring WebFlux, è stato aggiunto a Spring 5. È completamente non bloccante.
  Nelle applicazioni MVC tradizionali, un nuovo thread servlet viene creato (o ottenuto dal pool di thread) quando una richiesta arriva al server. 
  Il termine "reattivo" si riferisce a modelli di programmazione basati sulla reazione ai cambiamenti. 
  Approfondimenti:  https://howtodoinjava.com/spring-webflux/spring-webflux-tutorial/
  					https://dzone.com/articles/build-reactive-rest-apis-with-spring-webflux
  Richiede la dipendenza (import org.springframework.web.reactive.function.client.WebClient;)
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>  
 */


public class Person_WEB_Client {


	    private static final String BASE_URL = "http://localhost:8080/person/";

	    private WebClient webClient;

	    public Person_WEB_Client() {
	        this.webClient = WebClient.create();
	    }

	    public Flux<Person> getPersonList() {
	        return webClient.get()
	                .uri(BASE_URL+"list")
	                .accept(MediaType.APPLICATION_JSON)
	                .retrieve()
	                .bodyToFlux(Person.class);
	    }

	    public Mono<Person> getPersonById(int id) {
	        return webClient.get()
	                .uri(BASE_URL + id)
	                .accept(MediaType.APPLICATION_JSON)
	                .retrieve()
	                .bodyToMono(Person.class);
	    }

	    public Mono<Person> addPerson(Person person) {
	        return webClient.post()
	                .uri(BASE_URL+"add")
	                .contentType(MediaType.APPLICATION_JSON)
	                .bodyValue(person)
	                .retrieve()
	                .bodyToMono(Person.class);
	    }
	    
	    public Mono<Void> updatePerson(Person person) {
	        return webClient.put()
	                .uri(BASE_URL + person.getId())
	                .contentType(MediaType.APPLICATION_JSON)
	                .bodyValue(person)
	                .retrieve()
	                .bodyToMono(Void.class);
	    }

	    public Mono<Void> deletePersonById(int id) {
	        return webClient.delete()
	                .uri(BASE_URL + id)
	                .retrieve()
	                .bodyToMono(Void.class);
	    }
	}

